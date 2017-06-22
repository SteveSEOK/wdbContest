package yjc.wdb.bbs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import yjc.wdb.bbs.bean.Criteria;
import yjc.wdb.bbs.bean.PlaceVo;

import yjc.wdb.bbs.bean.Reservation;
import yjc.wdb.bbs.bean.evaluationVo;
import yjc.wdb.bbs.bean.Userbean;
import yjc.wdb.bbs.bean.pay;
import yjc.wdb.bbs.dao.PlaceDao;
import yjc.wdb.bbs.service.PlaceService;


@Controller
@SessionAttributes("u_id")


public class PlaceController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);
	
	@Inject
	PlaceService service;
	PlaceDao dao;

	@RequestMapping(value = "/place", method = RequestMethod.GET)
	public String place(HttpSession session, Userbean vo) throws Exception {
	String u_id=	(String)session.getAttribute("u_id");
	vo.setU_id(u_id);
		return "place/ShoppingMallAddForm";
	}

	@RequestMapping(value = "/place", method = RequestMethod.POST)
	public String ScheMainPOST(HttpSession session, PlaceVo place,@RequestPart("photo") MultipartFile file, HttpServletRequest req
			) throws Exception {
		if (file.isEmpty() == false) {
			/*
			 * Ŭ���̾�Ʈ�κ��� ���޹޾Ƽ� ���� ��ǻ�� ��򰡿� ����� ������ �츮�� ���ϴ� ��(resources/img)��
			 * ��������.
			 */
			try {
				System.out.println(place.toString());
				// 1. file ��ü�κ��� ���� ������ ����Ʈ���� �����´�.
				byte[] bytes = file.getBytes();

				// 2. bytes �迭�� ������ ������ ���� ����(resources/img) ���� ��θ� ���Ѵ�.
				String rootPath = req.getSession().getServletContext()
						.getRealPath("./resources/img");

				System.out.println("rootPath:" + rootPath);
				System.out.println(place.toString());
				// 3. rootPath�� ������ ������ �����ϴ��� �˻��ϰ�, �������� ������ �� ������ �����Ѵ�.
				File folder = new File(rootPath);
				if (folder.exists() == false)
					folder.mkdir();
				System.out.println(place.toString());
				// 4. �����ʿ� ����� �����̸��� Ŭ���̾�Ʈ ������ ������ ������ �����̸��� �����ϰ� �Ѵ�.
				String fileName = file.getOriginalFilename();
				String ext = fileName.substring(fileName.length() - 4,
						fileName.length());
				// System.out.println("Ȯ����:" + ext);
				fileName = "" + Calendar.getInstance().getTimeInMillis() + ext;
				// 5. rootPath �ؿ� fileName�� �ش��ϴ� ���Ͽ� ���޹��� ���ϳ���(bytes)��
				// ���� ���ؼ� BufferedOutputStream ��ü�� �����Ѵ�.
				File serverFile = new File(folder.getAbsolutePath() + "/"
						+ fileName);	System.out.println(place.toString());
				BufferedOutputStream stream = null;
				stream = new BufferedOutputStream(new FileOutputStream(
						serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println(place.toString());
				System.out.println("orgFileName:" + file.getOriginalFilename());
				place.setP_picture(fileName);
			    String u_id=(String)session.getAttribute("u_id");
				place.setU_id(u_id);
			    service.insertPlace(place);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}

		return "redirect:PlaceList";
	}

	@RequestMapping(value = "PlaceList", method = RequestMethod.GET)
	public String viewPlace(Model model, HttpServletRequest req, HttpSession session,Criteria2 criteria, RedirectAttributes rttr) throws Exception {
		String u_id=(String )session.getAttribute("u_id");
		List<PlaceVo> result = service.PlaceList(criteria);
		System.out.println(result);
		Userbean user=new Userbean();
		//System.out.println(criteria);
			
				rttr.addAttribute("searchType", criteria.getSearchType());
				rttr.addAttribute("keyword", criteria.getKeyword());
				//List<Board> list = service.listPage(criteria);
			
	
				
	
				int totalCount = service.getTotalCount();
				
				//System.out.println(totalCount);
				//System.out.println(criteria.getPage());
				model.addAttribute("criteria", criteria);
			
				criteria.setTotalCount(totalCount);
		model.addAttribute("placeList", result);
		return "/place/ShoppingMallList";
	}

	@RequestMapping(value = "viewPlace", method = RequestMethod.GET)
	public String viewPlace(Model model, HttpServletRequest req, HttpSession session, Integer p_id) throws Exception {

		PlaceVo p = service.getPlaceInfo(p_id);

		// return "redirect:viewMember";

      
		
		model.addAttribute("placeInfo", p);

		return "/place/ShoppingMallDetail";
	}

	@RequestMapping(value = "reservationForm", method = RequestMethod.GET)
	public String reservation(HttpSession session, PlaceVo vo, Model model, int p_id) {

		PlaceVo p = service.getPlaceInfo(p_id);
		model.addAttribute("a", p);

		return "/place/ReservationAddForm";
	}

	@RequestMapping(value = "reservationForm", method = RequestMethod.POST)

	public String reservationPost(Reservation res, HttpSession session)
			throws Exception {

		try{
		   String	u_id =(String)session.getAttribute("u_id");
		 
			System.out.println(u_id);
			System.out.println(u_id);
			res.setU_id(u_id);
			System.out.println(u_id);
			System.out.println(res.toString());
			service.insertReservation(res);
			 System.out.println("����������");
			System.out.println(res.toString());


		}catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
				return "redirect:reservationList";
	}

	@RequestMapping(value = "reservationList", method = RequestMethod.GET)
	public String reservationList(Model model, HttpServletRequest req, HttpSession session, Reservation res) {
	    String u_id=(String)session.getAttribute("u_id");
		List<Reservation> result = service.ReservationList(u_id);

		res.setU_id(u_id);
		System.out.println(u_id);
		res.setPr_id(res.getPr_id());
		res.setP_id(res.getP_id());
		model.addAttribute("reservation", result);

		return "/place/ReservationList";
	}

	@RequestMapping(value = "payment", method = RequestMethod.GET)
	public String payment(HttpSession session, Model model, Reservation reservation1,
			@RequestParam("pr_id") int pr_id) {
		String id = (String) session.getAttribute("id");
		Reservation reservation = service.getReservationInfo(pr_id);
		reservation.setU_id(id);
		reservation.setPr_id(pr_id);
		System.out.println(pr_id);
		model.addAttribute("reservation", reservation);
		return "/place/PayMentAddForm";
	}

	@RequestMapping(value = "payment", method = RequestMethod.POST)
	public String payment(pay pay,Reservation reservation) {
       
       System.out.println(reservation.getPr_id());
       int pr_id=reservation.getPr_id();
		pay.setPr_id(pr_id);
		service.insertpay(pay);

		return "redirect:reservationList";
	}

	@RequestMapping(value = "payList", method = RequestMethod.GET)
	public String paymentList(pay pay, Model model, HttpServletRequest req, HttpSession session) {
		String id = (String) session.getAttribute("id");
		List<pay> list = service.Paylist(id);

		Userbean member = new Userbean();
		member.setU_id(id);
		model.addAttribute("pay", list);
		return "/place/PayMentList";
	}

	@RequestMapping(value = "/deletePlace", method = RequestMethod.GET)
	public String deleteEvent(HttpSession session, Model model, @RequestParam(value = "p_id") int no) throws Exception {

		service.deletePlace(no);
		return "redirect:PlaceList";
	}

	
	@RequestMapping(value = "reply")
	public String comment(evaluationVo vo, HttpSession session, PlaceVo vo1, RedirectAttributes rttr) throws Exception {
		try {
			String id = (String) session.getAttribute("id");
			int p_no = vo1.getP_id();
			service.getPlaceInfo(p_no);
			vo.setId(id);
			System.out.println(vo.toString());
			System.out.println(vo1.getP_id());
			System.out.println("id" + id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "redirect:viewPlace";
	}

}
