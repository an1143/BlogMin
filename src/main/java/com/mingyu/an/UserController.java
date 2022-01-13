package com.mingyu.an;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mingyu.security.ShaEncoder;
import com.mingyu.service.BbsService;
import com.mingyu.vo.BbsVo;
import com.mingyu.vo.FindCriteria;
import com.mingyu.vo.PageCriteria;
import com.mingyu.vo.PagingMaker;

@Controller
@RequestMapping("/user/*")
public class UserController {

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	//@Inject
	//ShaEncoder shaEncoder;
	
	
	@RequestMapping(value = "/security", method = RequestMethod.GET)
	public String security( Model model ) throws Exception {
		                                 //URI에 success가 남는데 RedirectAttributes 사용하면 한번만 전송함 

		
	
		return "/UserSecurity";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model ) throws Exception {
		                                 //URI에 success가 남는데 RedirectAttributes 사용하면 한번만 전송함 

		System.out.println("로그인페이지입니다.");
	
		return "/user/login";
	}

	
	
	@RequestMapping(value = "/login_check", method = RequestMethod.GET)
	public String userJoin( Model model ) throws Exception {
		                                 //URI에 success가 남는데 RedirectAttributes 사용하면 한번만 전송함 

		System.out.println("회원가입페이지");
	
		return "/user/login_check";
	}
	
}
