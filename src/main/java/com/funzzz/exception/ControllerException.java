package com.funzzz.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class ControllerException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//handler描述出现异常的方法
		System.err.println(handler+"----handler------>");
		ModelAndView mav = new ModelAndView();
		
		if(ex instanceof UnauthorizedException){
			mav.addObject("mess", handler.toString()+"权限不足");
		}else if(ex instanceof AuthenticationException){
			mav.addObject("mess", handler.toString()+"身份验证失败");
		}else{
			mav.addObject("mess", "未知异常");
		}
		
		mav.setViewName("Demo/system/exceptionCatch.jsp");
		return mav;
	}

}
