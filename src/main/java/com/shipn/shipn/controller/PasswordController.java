package com.shipn.shipn.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shipn.shipn.dto.UserDto;
import com.shipn.shipn.dto.UserVO;
import com.shipn.shipn.service.MailService;
import com.shipn.shipn.service.UserService;

@Controller
@RequestMapping("/userInfo")
public class PasswordController {

	private static final Logger logger = LoggerFactory.getLogger(PasswordController.class);
	private final UserService userService;
	private final MailService mailService;
	
	public PasswordController(UserService userService,MailService mailService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
		this.mailService = mailService;
	}
	
	 // Receive the address and send an email
   @RequestMapping(value="/forgotPassword", method=RequestMethod.GET)
	public String forgotView(UserVO userVO) throws Exception{
		logger.info("Request Mapping /forgot password");
		return "userInfo/forgotPassword";
	}

	 // Receive the address and send an email
   @RequestMapping(value="/forgotPassword", method=RequestMethod.POST)
	public String validEmailAddress(UserDto userDto, HttpServletRequest request,RedirectAttributes redirectAttributes, Model model) throws Exception{
   	
		String email = request.getParameter("userEmail");
		String token = RandomStringUtils.randomAlphabetic(30);
		
		userDto.setEmail(email);
		userDto.setResetPasswordToken(token);
		
		logger.info("Request Mapping /forgot email :: " + userDto);
		
		int aaa = userService.findByEmail(userDto);

		logger.info("aa ::" + aaa);
		if(aaa != 1) {
			model.addAttribute("error","Wrong Email address");
			return null;
		}else {
			try {
				
				String resetPasswordURL = userService.getSiteURL(request) + "/userInfo/reset_password?token=" + token;
				logger.info("resetpassword Link :: " + resetPasswordURL) ;
				mailService.mailSending(email, resetPasswordURL);
				redirectAttributes.addFlashAttribute("message", "we have sent a resetpassword email.");
			}
			catch (Exception e) {
				// TODO: handle exception
				redirectAttributes.addFlashAttribute("message", "Email sending system something to wrong.");
			}
			
			return "redirect:/users/login";
		}
		
	} 
   
   @RequestMapping(value = "/reset_password", method=RequestMethod.GET)
   public String showResetPasswordForm(@RequestParam(value = "token") String token, Model model) throws Exception {
//	    UserVO userVO = userService.getByResetPasswordToken(token);
	    logger.info("Request Parameter :: " + token );
	    logger.info("Model attribute :: " + model );
//	    logger.info("userVO value :: " + userVO );
	    model.addAttribute("token", token);
	     
//	    if (userVO == null) {
	        model.addAttribute("message", "Invalid Token");
//	    }
	    
	    return "userInfo/reset_password_form";
	}
   
   @RequestMapping(value="/reset_password", method = RequestMethod.POST)
   public String processResetPassword(UserDto userDto, HttpServletRequest request, RedirectAttributes redirectAttributes ) {
	   
	    String token = request.getParameter("token");
	    String password = request.getParameter("password");
	    String hashedPw = BCrypt.hashpw(password, BCrypt.gensalt());
	    logger.info("password :: " + password);
	    
	    try {
		    userDto.setPassword(hashedPw);
		    userDto.setResetPasswordToken(token);
			userService.updatePwbyResetPasswordToken(userDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    redirectAttributes.addFlashAttribute("message", "You have successfully changed your password.");
	     
	    return "redirect:/users/login";
	}
   
}
