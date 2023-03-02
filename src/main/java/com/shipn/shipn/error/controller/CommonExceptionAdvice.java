package com.shipn.shipn.error.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionAdvice {
private static final Logger l = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	
		//@ExceptionHandler(NullPointerException.class) : NullPointerException
		@ExceptionHandler(Exception.class)
		public String common(Exception e, Model model) {
		l.info("E: common(e) 호출 "+e);
		System.out.println("E: common 호출"+e);
		model.addAttribute("e", e);
		return "common_error";
		}
	
	
//	@ExceptionHandler(Exception.class)
//	private ModelAndView errorModelAndView(Exception e) {
//		l.info("E: ModelAndView 호출 "+e);
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("common_error");
//		mav.addObject("e", e);
//		return mav;
//	}
	
	//@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public String commonMismatch(Exception e) {
		l.info("E: commonMismatch(e) 호출 "+e);
		System.out.println("E: commonMismatch 호출"+e);
		return "common_error";
		//출력값
		//INFO : com.itwiilbs.controller.CommonExceptionAdvice - E: commonMismatch(e) 호출 org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: ""
		//E: commonMismatch 호출org.springframework.web.method.annotation.MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'int'; nested exception is java.lang.NumberFormatException: For input string: ""

	}
}
