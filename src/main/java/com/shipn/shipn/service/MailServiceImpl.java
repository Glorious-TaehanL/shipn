package com.shipn.shipn.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.shipn.shipn.controller.UserLoginController;

@Component
public class MailServiceImpl implements MailService {

	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void mailSending(String recipientEmail, String link) {
		// TODO Auto-generated method stub

		logger.info("recipientEmail :: " + recipientEmail);
		logger.info("mailSender :: " + mailSender);
		
		String setfrom = "devaccte@gmail.com";
		String title = "Here's the link to reset your password";
		String content = "<p> Hello, </p>"
				 + "<p>You have requested to reset your password.</p>"
		            + "<p>Click the link below to change your password:</p>"
		            + "<p><a href=\"" + link + "\">Change my password</a></p>"
		            + "<br>"
		            + "<p>Ignore this email if you do remember your password, "
		            + "or you have not made the request.</p>";
		     
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); //must be setup. 
			messageHelper.setTo(recipientEmail); 
			messageHelper.setSubject(title); 
			messageHelper.setText(content,true); 

			mailSender.send(message);
		} catch (Exception e) {
			logger.info("try catch issue ");
			System.out.println(e);
		}

	}

}
