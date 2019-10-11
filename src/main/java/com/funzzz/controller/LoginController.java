package com.funzzz.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.funzzz.model.Employees;
import com.funzzz.model.Permission;
import com.funzzz.realm.LoginRealm;
import com.funzzz.service.EmployeesService;
import com.funzzz.service.PermissionService;

@Controller
public class LoginController {
	
	@Autowired
	private EmployeesService em;
	@Autowired
	PermissionService ps; 
	
	
	
	@RequestMapping("/login.action")
	public ModelAndView login(Employees emp,HttpServletRequest request){
		Employees temp = em.findEmployeeForLogin(emp);
		System.err.println(temp);
		ModelAndView mav = new ModelAndView();
		if(temp == null){
			mav.setViewName("index.jsp");
		}else{
			if("经理".equals(temp.getEmptype())){
				mav.setViewName("ManagerPage.jsp");
			}else if("普通员工".equals(temp.getEmptype())){
				mav.setViewName("EmployeePage.jsp");
			}
			request.getSession().setAttribute("employee", temp);
		}
		return mav;
	}
	
	
	@RequestMapping("/login2.action")
	public String login2(Employees emp){
		Employees temp = em.findEmployeeForLogin(emp);
		System.err.println(temp);
		
		if(temp == null){
			return "index.jsp";
		}else{
			if("经理".equals(temp.getEmptype())){
				return "ManagerPage.jsp";
			}else if("普通员工".equals(temp.getEmptype())){
				return "EmployeePage.jsp";
			}
		}
		return null;
	}
	//国际化语言页面跳转
	@RequestMapping("/changeLanguage.action")
	public String changeLanguage (Locale locale){
		System.err.println("---------------------changeLanguage222------------------------");
		return "redirect:index.action";
	}
	
	@RequestMapping("/loginForMyRealm.action")
	public ModelAndView loginForMyRealm(Employees emp,HttpSession session){
		System.err.println(emp+"------------------------------------hahahahahahahah----------------------------------------");
		ServletContext sc = session.getServletContext();
		
		if(sc.getAttribute("menuList") == null){
			System.err.println("-------------Load meun--------------");
			List<Permission> menuList = ps.findAllMeuns();//ps
			sc.setAttribute("menuList", menuList);
			
				for (Permission permission : menuList) {
					
					List<Permission> list = permission.getList();
					for (Permission permission2 : list) {
						System.err.println(permission.getPinfo()+"------------->"+permission2.getPinfo());
					}
				}
		}
		
		ModelAndView mav = new ModelAndView();
		DefaultSecurityManager  securityManager= new DefaultSecurityManager();
		LoginRealm realm = new LoginRealm();
		securityManager.setRealm(realm);
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(emp.getUsername(),emp.getPassword());
		System.err.println(emp.getUsername()+"来自token"+emp.getPassword());
		try{
			subject.login(token);
			System.err.println("认证成功");
			//session中存值用于获取该用户信息
			Employees user = em.findEmployeeForLogin(emp);
			System.out.println("-------------------------------------------"+user+"-------------------------------------------");
			session.setAttribute("user", user);
			//权限验证
			//认证成功后看一下身份根据身份跳到不同的页面
			mav.setViewName("ManagerPage.jsp");
			/*
			if("经理".equals(temp.getEmptype())){
				
			}else if("普通员工".equals(temp.getEmptype())){
				mav.setViewName("EmployeePage.jsp");
			}*/
			//subject.checkPermissions("user:insert");
		}catch(UnknownAccountException e){
			System.out.println("账号错误");
			mav.setViewName("index.jsp");
		}catch(IncorrectCredentialsException e){
			System.err.println("密码错误");
			mav.setViewName("index.jsp");
		}
		
		return mav;
	}
		//国际化语言页面跳转
		@RequestMapping("/addEmployees.action")
		public String addEmployee(Employees emp){
			System.err.println("====================加入用户================");
			int temp = em.addEmployeeForDatabase(emp);
			System.err.println(temp+"====================加入用户成功================");
			return "redirect:ManagerPage.jsp";
		}
		
		@RequestMapping("/loginOut.action")
		public String loginOut(){
			Subject  subject  = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.stop();
			subject.logout();
			return "index.jsp";
		}
		
	
}
