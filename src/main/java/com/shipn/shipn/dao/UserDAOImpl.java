package com.shipn.shipn.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shipn.shipn.controller.UserLoginController;
import com.shipn.shipn.dto.UserDto;
import com.shipn.shipn.dto.UserVO;
import com.shipn.shipn.security.CustomUserDetails;

@Repository
public class UserDAOImpl implements UserDAO {

	private static final String NAMESPACE = "com.shipn.shipn.mappers.user.UserMapper";
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	private final SqlSession sqlSession;
	
	@Inject
	public UserDAOImpl(SqlSession sqlSession) {
		// TODO Auto-generated constructor stub
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void register(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE + ".register", userVO);
	}

	@Override
	public CustomUserDetails getUserById(String id) {
	  CustomUserDetails users = sqlSession.selectOne(NAMESPACE + ".getUserById", id);
	  return users;
	}

	@Override
	public boolean findId(String userId) throws Exception {
		// TODO Auto-generated method stub
		int countOfindex = sqlSession.selectOne(NAMESPACE + ".findId", userId);
		return (countOfindex > 0) ? true:false;
	}
	
	@Override
	public boolean findName(String userName) throws Exception {
		// TODO Auto-generated method stub
		int countOfindex = sqlSession.selectOne(NAMESPACE + ".findName", userName);
		return (countOfindex > 0) ? true:false;
	}

	@Override
	public boolean findEmail(String userEmail) throws Exception {
		// TODO Auto-generated method stub
		int countOfindex = sqlSession.selectOne(NAMESPACE + ".findEmail", userEmail);
		return (countOfindex > 0) ? true:false;
	}


	@Transactional
	@Override
	public int update_pw(UserVO userVO) throws Exception{
		return sqlSession.update(NAMESPACE + ".update_pw", userVO);
	}

	@Override
	public int findByEmail(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		logger.info("userDAOImpl findByEmail Fun :: " + userDto);
		logger.info("userDAOImpl findByEmail Fun :: " + userDto.getEmail());
		String email =  userDto.getEmail();
		int users = sqlSession.selectOne(NAMESPACE + ".findByEmail", email);
		logger.info("userDAOImpl findByEmail users ::" + sqlSession.selectOne(NAMESPACE + ".findByEmail", email)); 
		return users;
	}

	@Override
	public void updateResetPasswordToken(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		logger.info("updateResetPasswordToken parameter value [email] :: " + userDto);
//		logger.info("updateResetPasswordToken parameter value [token] :: " + resetPasswordToken);
		sqlSession.update(NAMESPACE + ".updateResetPasswordToken",userDto);
		
	}
	
	@Override
	public UserDto updatePwbyResetPasswordToken(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		logger.info("userDAOImpl findUserByToken Fun [Token value] :: " + userDto);
		
		return sqlSession.selectOne(NAMESPACE + ".updatePwByToken",userDto);
	}
}
