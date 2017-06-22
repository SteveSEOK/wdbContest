package yjc.wdb.bbs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import yjc.wdb.bbs.bean.Userbean;
import yjc.wdb.bbs.service.memberService;




@Controller

public class memberController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(memberController.class);
	
	
	@Inject
	memberService service;
	@RequestMapping(value="/insertmember", method=RequestMethod.GET)
	public String  join() throws Exception{
				
		return"Member/join";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String  login() throws Exception{
		
		return"Member/login";
	}
	@Resource(name="uploadPath")
	private String uploadPath;
	@RequestMapping(value = "insertmember", method = RequestMethod.POST)
	public String join(Userbean m,
			@RequestParam("photo") MultipartFile file, HttpServletRequest req,
			HttpSession session) {
		if (file.isEmpty() == false) {
			/*
			 * Ŭ���̾�Ʈ�κ��� ���޹޾Ƽ� ���� ��ǻ�� ��򰡿� ����� ������ �츮�� ���ϴ� ��(resources/img)��
			 * ��������.
			 */
			try {
				System.out.println(m.toString());
				// 1. file ��ü�κ��� ���� ������ ����Ʈ���� �����´�.
				byte[] bytes = file.getBytes();

				// 2. bytes �迭�� ������ ������ ���� ����(resources/img) ���� ��θ� ���Ѵ�.
			String rootPath = req.getSession().getServletContext()
					.getRealPath("./resources/upload");
	
				System.out.println("rootPath:" + rootPath);
				System.out.println(m.toString());
				// 3. rootPath�� ������ ������ �����ϴ��� �˻��ϰ�, �������� ������ �� ������ �����Ѵ�.
				File folder = new File(rootPath);
				if (folder.exists() == false)
					folder.mkdir();
				System.out.println(m.toString());
				// 4. �����ʿ� ����� �����̸��� Ŭ���̾�Ʈ ������ ������ ������ �����̸��� �����ϰ� �Ѵ�.
				String fileName = file.getOriginalFilename();
				String ext = fileName.substring(fileName.length() - 4,
						fileName.length());
				// System.out.println("Ȯ����:" + ext);
				fileName = "" + Calendar.getInstance().getTimeInMillis() + ext;
				// 5. rootPath �ؿ� fileName�� �ش��ϴ� ���Ͽ� ���޹��� ���ϳ���(bytes)��
				// ���� ���ؼ� BufferedOutputStream ��ü�� �����Ѵ�.
				File serverFile = new File(folder.getAbsolutePath() + "/"
						+ fileName);	System.out.println(m.toString());
				BufferedOutputStream stream = null;
				stream = new BufferedOutputStream(new FileOutputStream(
						serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println(m.toString());
				System.out.println("orgFileName:" + file.getOriginalFilename());
				m.setU_profile(fileName);
				session.setAttribute("id", m.getU_id());
				System.out.println(m.toString());
				  service.insertMember(m);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return "redirect:home";
	}

	@RequestMapping(value="/login")
	public String loginGET(HttpServletRequest request, Userbean vo,HttpSession session,RedirectAttributes rttr,PrintWriter out) throws Exception {
		String URL = "";
		String pw=vo.getU_pass();
		if(service.login(vo)!=null){
			request.getSession().setAttribute("u_id", vo.getU_id());
			rttr.addFlashAttribute("response","success");
	           
			URL ="redirect:/home";

		
		
		}
		
			return URL = "redirect:home"; 	

	}
		
		
		
		
		
			
			
		 
		

		
		
	@RequestMapping(value = "viewMember", method = RequestMethod.GET)
	public String viewMember(Model model, HttpServletRequest req, HttpSession session,String u_id) {
		u_id=(String)session.getAttribute("u_id");
		System.out.println("viewMember1:" + u_id);
        Userbean m=new Userbean();  	
        System.out.println(m.getU_hp());
        System.out.println(m.getU_id());
        System.out.println(m.toString());
 		m.setU_id(u_id); 
        m = service.view(u_id);
        
		// return "redirect:viewMember";
		model.addAttribute("userInfo", m);
		return "/Member/viewMember";
	}
	// ��� ȸ���� ���� ����
	@RequestMapping(value = "viewAllMember", method = RequestMethod.GET)
	public String viewAllMember(Model model, HttpServletRequest req, HttpSession session) {
		List<Userbean > result = service.getMemberAll();
		// return "redirect:viewMember";
		model.addAttribute("userInfos", result);
		return "/Member/viewMemberAll";
	}
		
	@RequestMapping(value="/logout")
	public String  loginForm(HttpSession session) throws Exception{
	session.invalidate();
		
		return"redirect:home";
	}	
	@RequestMapping(value="/joinCheck", method = RequestMethod.POST)
	@ResponseBody
	public String joinCheck(@RequestParam("id")String id) throws Exception{
		String str = "";
		if(service.check(id)==null){
			str="true";
		}
		
		return str;
	}
	
}
