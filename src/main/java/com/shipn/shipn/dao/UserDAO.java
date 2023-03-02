package com.shipn.shipn.dao;

import com.shipn.shipn.dto.*;
import com.shipn.shipn.security.CustomUserDetails;

public interface UserDAO {
	
	void register(UserVO userVO) throws Exception;

	CustomUserDetails getUserById(String username);
	
	// Validation check before customer registration.	
	boolean findId(String userId) throws Exception;
	boolean findName(String userName) throws Exception;
	boolean findEmail(String userEmail) throws Exception;
	
	int update_pw(UserVO userVO) throws Exception;
	
	int findByEmail(UserDto userDto) throws Exception;
	
	void updateResetPasswordToken(UserDto userDto) throws Exception;
	
	UserDto updatePwbyResetPasswordToken(UserDto userDto) throws Exception; 
}
