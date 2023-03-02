package com.shipn.shipn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/users")
@Controller
public class UserLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	@GetMapping("/login")
	public void loginPage(String error, String logout, Model model) {
		if(error != null) { 
			model.addAttribute("error","failed login"); 
		} 
		if(logout != null) { 
			model.addAttribute("logout","logout"); 
		}
	}
//	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public void loginPage(String error, String logout, Model model, @RequestParam("excepId") int excepId) {
//		logger.info("excepId : " + excepId );
//		
//		if(error != null) { 
//			model.addAttribute("error","failed login"); 
//		} 
//		if(logout != null) { 
//			model.addAttribute("logout","logout"); 
//		}
//	}
	
	@PostMapping("/login-processing")
	public void loginProcessing(String error) {
		logger.info("login-processing!");
		logger.info("err :" + error );
	}
	
	@GetMapping("/member") 
	public void doMember() { 
		logger.info("member~"); 
	} 
	
	@GetMapping("/admin") 
	public void doAdmin() { 
    		logger.info("admin~"); 
	}
	
	@GetMapping("/search") 
	public void doSearch() { 
    		logger.info("search~"); 
	}
	@GetMapping("/settings") 
	public void doSeetting() { 
    		logger.info("search~"); 
	}
	
}