	package yjc.wdb.bbs;
	
	import java.text.DateFormat;
	import java.util.Date;
	import java.util.List;
	import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
	
	import yjc.wdb.bbs.bean.Board;
import yjc.wdb.bbs.bean.Contest;
import yjc.wdb.bbs.bean.Criteria;
import yjc.wdb.bbs.bean.Schedule;
import yjc.wdb.bbs.service.BoardService;
import yjc.wdb.bbs.service.ContestService;
	
	/**
	 * Handles requests for the application home page.
	 */
	@Controller
	public class HomeController1 {
		private BoardService service;
		private ContestService Cservice;
		private static final Logger logger = LoggerFactory.getLogger(HomeController1.class);
		
		/**
		 * Simply selects the home view to render by returning its name.
		 */
		@RequestMapping(value = "", method = RequestMethod.GET)
		public String home(Locale locale, Model model) {
			logger.info("Welcome home! The client locale is {}.", locale);
			
			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			
			String formattedDate = dateFormat.format(date);
			
			model.addAttribute("serverTime", formattedDate );
			
			return "home";
		}
		
		
		
		
		@RequestMapping(value="home",method=RequestMethod.GET)
		public String list( Model model) throws Exception{
		
			
			
			
			return "Member/index";
		}
		
	
		
		@RequestMapping(value="/join")
		public String  join() throws Exception{
			
			return"Member/join";
		}
	
		@RequestMapping(value="/top")
		public String  top() throws Exception{
			
			return"Member/top";
		}
		@RequestMapping(value="/missingPassword")
		public String  Missingpassword() throws Exception{
			
			return"Member/MissingPassword";
		}
		@RequestMapping(value="/MIssingID")
		public String  MissingID() throws Exception{
			
			return"Member/MIssingID";
		}
	}
