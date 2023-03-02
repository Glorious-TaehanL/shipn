package com.shipn.shipn.service;

import javax.servlet.http.HttpServletRequest;

import com.shipn.shipn.dto.UserDto;
import com.shipn.shipn.dto.UserVO;

public interface UserService {
	void register(UserVO userVO) throws Exception;
	
	boolean findId(String userID) throws Exception;
	
	boolean findName(String userName) throws Exception;
	
	boolean findEmail(String userEmail) throws Exception;
	
	String getSiteURL(HttpServletRequest request) throws Exception;
	
	int findByEmail(UserDto userDto) throws Exception;
	
//	void updateResetPasswordToken(String userEmail,String userToken) throws Exception;
	
	UserDto updatePwbyResetPasswordToken(UserDto userDto) throws Exception; 
}
