package com.mingyu.an;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice  //컨트롤에서 발생하는 예외처리를 전문적으로 처리함 
public class ExceptionAdvice {

	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);
	
	
//	@ExceptionHandler(Exception.class)
//	public String common(Exception e) {
//		
//		
//		logger.info(e.toString());
//		
//		
//		return "err_exception";
//	}
	
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errMAV(Exception e) {
		
		
		logger.info("ModelAndView....");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/err_exception");
		mav.addObject("exception", e);
		
		
		return mav;
	}
	
}
