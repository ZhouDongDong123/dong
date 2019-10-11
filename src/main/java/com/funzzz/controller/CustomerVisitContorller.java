package com.funzzz.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funzzz.model.Customer;
import com.funzzz.model.Customervisit;
import com.funzzz.model.Employees;
import com.funzzz.service.CustomerService;
import com.funzzz.service.CustomervisitService;
import com.funzzz.service.EmployeesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerVisitContorller {
	/*private final Integer myPageSize = 5;*/
	/**
     * 使用pageHelper插件实现分页查询
     * @param pn：pageNum的缩写，表示页数，默认值为1，即首页。
     * @param model：是MVC里的Model，作用是将用户信息及分页信息存在此model里，以便发送给页面
     * @return ：返回到视图解析器下的jsp页面
     */
	public static final int myPageSize = 5;
	@Autowired
	CustomervisitService cvs;
	@Autowired
	CustomerService cs;
	@Autowired
	EmployeesService es;
	
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/showCustomervisit.action")
	@RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
    public String showCustomervisit(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
    	System.out.println("================================showCustomervisit进来了=====================================");
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
        PageHelper.startPage(pn, 5);
        //从当前类下注入的业务层实现类CustomervisitsService中调用方法，该方法所在类利用注入的CustomervisitsDao来调用真正的查询方法查询数据库信息。
        List<Customervisit> allCustomervisits = cvs.findAllCustomervisit();
        //给username 和 cusname字段赋值
        String username = "";
        String cusname="";
        if(allCustomervisits!=null ){
        	for (Customervisit customervisit : allCustomervisits) {
        		username = es.findUserNameById(customervisit.getEmpId());
        		cusname = cs.findCusNameById(customervisit.getCid());
        		customervisit.setUsername(username);
        		customervisit.setCusname(cusname);
        		//不用date类型的了
        		customervisit.setFormatDate(new SimpleDateFormat("yyyy-MM-dd").format(customervisit.getDate()));
			}
        }
        
        System.err.println(allCustomervisits);
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo<Customervisit> page = new PageInfo<Customervisit>(allCustomervisits,5);
        //利用CustomervisitsService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
        model.addAttribute("pageInfo", page);
        return "Demo/customerVisit/showAllCustomersVisit.jsp";
    }
	
	 @RequestMapping(value="/showmyCustomervisit.action")
	 @RequiresRoles(value={"employee"},logical=Logical.OR)
	    public String showmyCustomervisit(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model,HttpSession session) {
	    	System.out.println("================================showmyCustomervisit进来了=====================================");
	        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
	        PageHelper.startPage(pn, 5);
	        //从当前类下注入的业务层实现类CustomervisitsService中调用方法，该方法所在类利用注入的CustomervisitsDao来调用真正的查询方法查询数据库信息。
	        Employees emp = (Employees) session.getAttribute("user");
	        //通过emp员工找所有顾客
	        List<Customervisit> allCustomervisits = null;
	        if(emp  != null){
	        	allCustomervisits = cvs.findAllCustomervisitByUsername(emp.getUsername());
	        }
	        
	        //给username 和 cusname字段赋值
	        String username = "";
	        String cusname="";
	        if(allCustomervisits!=null ){
	        	for (Customervisit customervisit : allCustomervisits) {
	        		username = es.findUserNameById(customervisit.getEmpId());
	        		cusname = cs.findCusNameById(customervisit.getCid());
	        		customervisit.setUsername(username);
	        		customervisit.setCusname(cusname);
	        		//不用date类型的了
	        		if(customervisit.getDate() != null){
	        			customervisit.setFormatDate(new SimpleDateFormat("yyyy-MM-dd").format(customervisit.getDate()));
	        		}
	        		
				}
	        }
	        
	        System.err.println(allCustomervisits);
	        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
	        PageInfo<Customervisit> page = new PageInfo<Customervisit>(allCustomervisits,5);
	        //利用CustomervisitsService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
	        model.addAttribute("pageInfo", page);
	        return "Demo/customerVisit/showAllCustomersVisit.jsp";
	    }
	
	
	
	
	//修改用户
    @RequestMapping(value="/modifycustomervisit.action")
    @RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  modifycustomervisit(Customervisit customervisit,ModelAndView mav){
    	//得到删除数据的id和当前页
    	System.err.println("----------------------modifycustomervisit-----------------------------");
    	//数据处理
    	DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
    	Date date;
    	int temp = 1;
		try {
			date = fmt.parse(customervisit.getFormatDate());
			customervisit.setDate(date);
		} catch (ParseException e) {
			temp=0;
		}
		temp = cvs.modifyByPrimaryKeySelective(customervisit);
		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		if (temp == 1) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");	
		}
		//返回视图
		mav.setViewName("deleteEmployee.jsp");
		return resultMap;
	}
	//增加准备选择框
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/readyCustomerForCustomervisit.action")
    @RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
    public @ResponseBody List<Customer> readyCustomerForCustomervisit() {
    	System.err.println("================================readyCustomerForCustomervisit进来了=====================================");
        //查询所有顾客
    	List<Customer> list  = cs.findAllCustomer();//cs.findEmployeesByCid(cid);
    	for (Customer customer : list) {
			System.err.println(customer);
		}
        return list;
    }
    
  //增加准备选择框
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/readyEmployeeForCustomervisit.action")
    @RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
    public @ResponseBody List<Employees> readyEmployeeForCustomervisit() {
    	System.err.println("================================readyCustomerForCustomervisit进来了=====================================");
        //查询所有顾客
    	List<Employees> list  = es.getAllEmployees();//cs.findEmployeesByCid(cid);
        return list;
    }
    //增加访问记录
  //增加用户（存在问题增加异常未处理）
    @RequestMapping(value="/addCustomervisit.action")
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor = RuntimeException.class)
    @RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
    public String addCustomervisit(Customervisit customervisit,Model model) {//这里的emp的`emptype`值是0，1，5
      //数据处理 
       Date date = null;
       DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
       try {
		   date = fmt.parse(customervisit.getFormatDate());
		   customervisit.setDate(date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		System.out.println("日期输入错误");
	}
       System.err.println(customervisit+"=========增加==============");
       //增加访问记录
       int temp = 0;
       temp = cvs.addSelective(customervisit);
       System.err.println("增加employee"+temp);

       return "redirect:showmyCustomervisit.action";
    }
    
  //删除用户删除单个用户
    @RequestMapping(value="/removeOnecustomervisit.action")
    @RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  removeOnecustomervisit(String id,String currentPage,ModelAndView mav){
 
		//得到删除数据的id和当前页
    	int visitId = Integer.parseInt(id);
		int temp = cvs.removeByPrimaryKey(visitId);
		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		if (temp==1) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");	
		}
		//返回视图
		mav.setViewName("deleteEmployee.jsp");
		return resultMap;
	}
    
    //删除多个用户
    @RequestMapping(value="/removeMorecustomervisits.action")
    @RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  removeMorecustomervisits(@RequestParam(value ="ids[]") Integer[] ids,String currentPage,ModelAndView mav){
    	//得到删除数据的id和当前页
    	int temp;
    	boolean test = true;
    	if(ids != null && ids.length!=0){
    		for(int i=0;i<ids.length;i++){
    			temp = cvs.removeByPrimaryKey(ids[i]);
    			if(temp != 1){
    				//此处应该事务回滚
    				test = false;
    			}
        	}
    	}else{
    		test = false;
    	}
		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		
		if (test==true) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");	
		}
		//返回视图
		mav.setViewName("deleteEmployee.jsp");
		return resultMap;
	}
    
    
    
}
