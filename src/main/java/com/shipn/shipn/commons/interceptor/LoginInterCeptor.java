/*
* [Ted comment]
* change to login feature (using login interceptor. -> Using spring security login handler)
*
*/
/*
package com.shipn.shipn.commons.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterCeptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterCeptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

		HttpSession httpSession = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("user");
	
		if(userVO != null) {
			logger.info("new login success");
			httpSession.setAttribute(LOGIN, userVO);
			response.sendRedirect("/");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		
		HttpSession httpSession = request.getSession();
		logger.info(httpSession.toString());
//		logger.error(msg);
		if(httpSession.getAttribute(LOGIN) != null) {
			logger.info("clean login data before");
			httpSession.removeAttribute(LOGIN);
		}
		
		return true;
	}
}
*/