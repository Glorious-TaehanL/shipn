package com.shipn.shipn.error.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shipn.shipn.controller.UserLoginController;

@Controller
@RequestMapping("/commonError")
public class CommonErrorPageRedirect {
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class); 

	@RequestMapping(value = "/throwable")
	public String throwable(HttpServletRequest request, Model model) {
		logger.info("throwable");
		pageErrorLogging(request);
		model.addAttribute("errorCode", "throwable");
		model.addAttribute("errorMsg", "Catch throw the error");
		return "common/commonErrorTheme";
	}
	
	@RequestMapping(value = "/exception")
	public String exception(HttpServletRequest request, Model model) {
		logger.info("exception");
		pageErrorLogging(request);
		model.addAttribute("errorCode", "exception");
		model.addAttribute("errorMsg", "Catch the exception");
		return "common/commonErrorTheme";
	}
	
	@RequestMapping(value="/400")
	public String errorController400(HttpServletResponse httpServletResponse, HttpServletRequest request, Model model) {
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		pageErrorLogging(request);
		model.addAttribute("errorCode", "400");
		model.addAttribute("errorMsg", "Your client has issued a malformed or illegal request");
		return "common/commonErrorTheme";
	}
	
	@RequestMapping(value="/403")
	public String errorController403(HttpServletResponse httpServletResponse, HttpServletRequest request, Model model) {
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		pageErrorLogging(request);
		model.addAttribute("errorCode", "403");
		model.addAttribute("errorMsg", "You don't have permission to access on this server");
		return "common/commonErrorTheme";
	}
	
	@RequestMapping(value="/404")
	public String errorController404(HttpServletResponse httpServletResponse, HttpServletRequest request, Model model) {
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		pageErrorLogging(request);
		model.addAttribute("errorCode", "404");
		model.addAttribute("errorMsg", "The resource requested could not be found on this server");
		return "common/commonErrorTheme";
	}
	
	@RequestMapping(value="/500")
	public String errorController500(HttpServletResponse httpServletResponse, HttpServletRequest request, Model model) {
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		pageErrorLogging(request);
		model.addAttribute("errorCode", "500");
		model.addAttribute("errorMsg", "There was an error. Please try again later.");
		return "common/commonErrorTheme";
	}
	
	private void pageErrorLogging(HttpServletRequest request) {
		logger.warn("[ status_code \t ] :: " + request.getAttribute("javax.servlet.error.status_code"));
		logger.warn("[ exception_type \t ] :: " + request.getAttribute("javax.servlet.error.exception_type"));
		logger.warn("[ request_uri \t ] :: " + request.getAttribute("javax.servlet.error.request_uri"));
		logger.warn("[ exception \t ] :: " + request.getAttribute("javax.servlet.error.exception"));
		logger.warn("[ servlet_name \t ] :: " + request.getAttribute("javax.servlet.error.servlet_name"));
		logger.warn("[ message \t ] :: " + request.getAttribute("javax.servlet.error.message"));
	}
}
