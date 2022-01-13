package com.mingyu.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model, ModelAndView modelAndView) {
		logger.info("Welcome admin/management!", locale);


		/*게시판 목록 보여주기*/
		
		
		
		
		
		

		modelAndView.setViewName("admin/management");
		return modelAndView;
	}


}
