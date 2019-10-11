package com.funzzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class JumpController {
	//进入项目就跳转到登陆页面
	@RequestMapping("/index.action")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
	//****************************************Manager**************************************************
	//这个是让在ManagerPage中的right页面进行跳转
	@RequestMapping("/right.action")
	public ModelAndView right(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("right.jsp");
		return mav;
	}
	
	@RequestMapping("/addEmployee.action")
	public ModelAndView addEmployee(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Demo/employee/addEmployee.jsp");
		return mav;
	}
	//****************************************Manager**************************************************
	//这个是让在showAllCustomer中跳转到增加顾客页面
	@RequestMapping("/jumpAddCustomerPage.action")
	public ModelAndView jumpAddCustomerPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Demo/customer/addCustomer.jsp");
		return mav;
	}
	//这个是让在showAllCustomer中跳转到增加顾客页面
		@RequestMapping("/jumpAddMyCustomerPage.action")
		public ModelAndView jumpAddMyCustomerPage(){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("Demo/customer/addmyCustomer.jsp");
			return mav;
		}

	//****************************************customerVisit**************************************************
	//这个是让在showAllCustomer中跳转到增加顾客页面
	@RequestMapping("/jumpaddCustomervisitPage.action")
	public ModelAndView jumpaddCustomervisitPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Demo/customerVisit/addCustomervisit.jsp");
		return mav;
	}
	
	@RequestMapping("/jumpaddSystemPasswordPage.action")
	public ModelAndView jumpaddSystemPasswordPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Demo/system/modifyPassword.jsp");
		return mav;
	}
	@RequestMapping("/jumpUserInfoPage.action")
	public ModelAndView jumpUserInfoPage(){
		System.err.println("------------------------jumpUserInfoPage--------------------------");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Demo/system/info.jsp");
		return mav;
	}
}
