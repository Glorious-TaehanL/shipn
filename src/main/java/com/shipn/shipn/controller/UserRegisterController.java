package com.shipn.shipn.controller;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shipn.shipn.dto.UserVO;
import com.shipn.shipn.service.UserService;

@Controller
@RequestMapping("/users")
public class UserRegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	private final UserService userService;
	
	@Inject
	public UserRegisterController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}
	
	// validation check customer registration.	
	@RequestMapping(value = "/register/finduserId", method = RequestMethod.GET)
	@ResponseBody
	public boolean findId(@RequestParam("userId") String userId) throws Exception {
		return userService.findId(userId);
	}
	
	@RequestMapping(value = "/register/finduserName", method = RequestMethod.GET)
	@ResponseBody
	public boolean findName(@RequestParam("userName") String userName) throws Exception {
		return userService.findName(userName);
	}
	
	@RequestMapping(value = "/register/finduserEmail", method = RequestMethod.GET)
	@ResponseBody
	public boolean findEmail(@RequestParam("userEmail") String userEmail) throws Exception {
		return userService.findEmail(userEmail);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGET() throws Exception{
		return "/users/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("Request Mapping /register :: " + userVO);
		String hashedPw = BCrypt.hashpw(userVO.getUserPw(), BCrypt.gensalt());
		userVO.setUserPw(hashedPw);
		userService.register(userVO);
		redirectAttributes.addFlashAttribute("message", "REGISTERED");
		
		return "redirect:/users/login";
	}
	
}

