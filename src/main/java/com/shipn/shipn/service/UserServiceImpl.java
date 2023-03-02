package com.shipn.shipn.service;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipn.shipn.dao.UserDAO;
import com.shipn.shipn.dto.UserDto;
import com.shipn.shipn.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {

	private final UserDAO userDAO;
	
	@Autowired
	MailService mailService;	
	
	@Inject
	public UserServiceImpl(UserDAO userDAO) {
		// TODO Auto-generated constructor stub
		this.userDAO = userDAO;
	}
	
	@Override
	public void register(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userDAO.register(userVO);
	}
	
	@Override
	public boolean findId(String userID) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findId(userID);
	}
	
	@Override
	public boolean findName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findName(userName);
	}
	
	@Override
	public boolean findEmail(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findEmail(userEmail);
	}

	@Override
	public String getSiteURL(HttpServletRequest request) throws Exception {
		// TODO Auto-generated method stub
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(),"");
	}
	
	@Override
	public int findByEmail(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		 if(userDAO.findByEmail(userDto) > 0) {
			 try {
				 userDAO.updateResetPasswordToken(userDto);
				 return 1;
			 }catch (Exception e) {
				// TODO: handle exception
				 return 0;
			}
		 }else {
			 return 0;	 
		 }
		 
		 
	}

	@Override
	public UserDto updatePwbyResetPasswordToken(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.updatePwbyResetPasswordToken(userDto);
	}

}


