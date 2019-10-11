package com.funzzz.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		Object temp = request.getSession().getAttribute("employee");
		String path = request.getRequestURI();
		if(path.contains("index") || path.contains("login") || path.contains("changeLanguage")){
			System.err.println(path+"----------------------------");
			return true;
		}else{
			if(temp == null){
				//session中没值就去登陆
				response.sendRedirect(request.getContextPath()+"/index.action");
				return false;
			}else{
				return true;
			}
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
