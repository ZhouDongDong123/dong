package com.funzzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
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

import com.funzzz.model.Employees;
import com.funzzz.service.CustomershareService;
import com.funzzz.service.CustomervisitService;
import com.funzzz.service.EmployeesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
class EmployeeController {
	/*private final Integer myPageSize = 5;*/
	/**
     * 使用pageHelper插件实现分页查询
     * @param pn：pageNum的缩写，表示页数，默认值为1，即首页。
     * @param model：是MVC里的Model，作用是将用户信息及分页信息存在此model里，以便发送给页面
     * @return ：返回到视图解析器下的jsp页面
     */
	public static final int myPageSize = 5;
	@Autowired
	EmployeesService es;
	
	@Autowired
	CustomershareService css;
	@Autowired
	CustomervisitService cvs;
	
	
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/showEmployee.action")
	@RequiresRoles(value={"admin"})
    public String getAllEmployees(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
    	System.out.println("================================showEmployee进来了=====================================");
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
        PageHelper.startPage(pn, 5);
        //从当前类下注入的业务层实现类EmployeesService中调用方法，该方法所在类利用注入的EmployeesDao来调用真正的查询方法查询数据库信息。
        List<Employees> allEmployees = es.getAllEmployees();
        
        //此时有顾客的
       /* System.out.println("-------------------------专员的顾客----------------------------");
        for (Employees e : allEmployees) {
        	List<Customer> list = e.getList();
        	if(list!=null){
        		for (Customer c : list) {
    				System.err.println(e.getName()+"---->"+c);
    			}
        	}
        	
		}*/
        
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo<Employees> page = new PageInfo<Employees>(allEmployees,5);
        //利用EmployeesService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
        model.addAttribute("pageInfo", page);
        return "Demo/employee/showEmployee.jsp";
    }
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/showEmployeeByCondition.action")
	@RequiresRoles(value={"admin","manager"},logical=Logical.OR)
    public String getAllEmployeesByCondition(@RequestParam(value="pn",defaultValue="1") Integer pn,@RequestParam(value="condition",defaultValue="2013")String condition,HttpServletRequest request,Model model) {
    	System.err.println("================================showEmployeeByCondition进来了=====================================");
    	System.err.println(pn+" ===="+request.getRequestURI()+"==== "+condition);
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
        PageHelper.startPage(pn, 5);
        //从当前类下注入的业务层实现类EmployeesService中调用方法，该方法所在类利用注入的EmployeesDao来调用真正的查询方法查询数据库信息。
        List<Employees> allEmployees = es.getAllEmployeesByCondition(condition);
        
        for (Employees employees : allEmployees) {
			System.err.println(employees);
		}
        
        System.err.println(allEmployees);
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo<Employees> page = new PageInfo<Employees>(allEmployees,5);
        //利用EmployeesService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
        model.addAttribute("pageInfo", page);
        return "Demo/employee/showEmployeeForCondition.jsp";
    }
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/updateEmployee.action")
    @RequiresRoles(value={"admin"},logical=Logical.OR)
    public String getAllEmployeesForUpdate(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
        PageHelper.startPage(pn, 5);
        //从当前类下注入的业务层实现类EmployeesService中调用方法，该方法所在类利用注入的EmployeesDao来调用真正的查询方法查询数据库信息。
        List<Employees> allEmployees = es.getAllEmployees();
        System.err.println(allEmployees);
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo<Employees> page = new PageInfo<Employees>(allEmployees,5);
        //利用EmployeesService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
        model.addAttribute("pageInfo", page);
        return "Demo/employee/updateEmployee.jsp";
    }
    
    
    //外键检测
  //为移除做准备 外键检查
  	@RequestMapping(value="/removeOneEmployeeReady.action")
  	@RequiresRoles(value={"admin","manager"},logical=Logical.OR)
  	public @ResponseBody Map<String,Object> removeOneEmployeeReady(@RequestParam(value="empId",defaultValue="0")Integer empId,@RequestParam(value="currentPage",defaultValue="1")Integer pageNum,ModelAndView mav){
  		System.err.println("================================removeOneEmployeeReady进来了=====================================");
  		//1、这里应该去查两个表的外键
  		//1）先去共享表 如果该表通过cid查出来数量大于0 那就不能删除提示用户外键
  		int cssCount = css.findForeignKeyByEmpId(empId) ;//css.findForeignKeyByCid(cid);
  		//2）再去访问 如果该表通过cid查出来数量大于0 那就不能删除提示用户外键
  		int cvsCount = cvs.findForeignKeyByCidForCss(empId);//cvs.findForeignKeyByCidForCvs(cid);
  		//success:正常  1：cssCount有问题 2： cvsCount有问题 3：两个都有问题
  		Map<String,Object> resultMap = new HashMap<String, Object>(); 

  		if (cssCount==0 && cvsCount==0) {
  			resultMap.put("type", "success");
  		}else{
  			if(cssCount != 0 && cvsCount == 0){
  				resultMap.put("type", "1");
  			}else if(cssCount == 0 && cvsCount != 0 ){
  				resultMap.put("type", "2");
  			}else{
  				resultMap.put("type", "3");
  			}
  		}
  		//返回视图
  		mav.setViewName("showAllCustomers.jsp");
  		return resultMap;
  	 }
  	/*/为移除做准备 外键检查*/
  	@RequestMapping(value="/removeMoreEmployeeReady.action")
  	@RequiresRoles(value={"admin","manager"},logical=Logical.OR)
  	public @ResponseBody Map<String,Object> removeMoreEmployeeReady(@RequestParam(value="emp_ids[]",defaultValue="0")Integer[] emp_ids,@RequestParam(value="currentPage",defaultValue="1")Integer pageNum,ModelAndView mav){
  		System.err.println("================================removeMoreEmployeeReady进来了=====================================");
  		//1、这里应该去查两个表的外键
  		//1）先去共享表 如果该表通过cid查出来数量大于0 那就不能删除提示用户外键
  		
  		boolean cssForeign = true;
  		boolean cvsForeign = true;
  		int cssCount = 0;
  		int cvsCount = 0;
  		if(emp_ids!=null && emp_ids.length!=0){
  			for (Integer id : emp_ids) {
  				cssCount = css.findForeignKeyByEmpId(id);
  				cvsCount = cvs.findForeignKeyByCidForCss(id);
  				if(cssCount>0){
  					cssForeign = false;
  				}
  				if(cvsCount>0){
  					cvsForeign = false;
  				}
			}
  		}
  		
  		
  	 ;//css.findForeignKeyByCid(cid);
  		//2）再去访问 如果该表通过cid查出来数量大于0 那就不能删除提示用户外键
  		//cvs.findForeignKeyByCidForCvs(cid);
  		//success:正常  1：cssCount有问题 2： cvsCount有问题 3：两个都有问题
  		Map<String,Object> resultMap = new HashMap<String, Object>(); 

  		if (cssForeign==true && cvsForeign==true) {
  			resultMap.put("type", "success");
  		}else{
  			if(cssForeign != true && cvsForeign == true){
  				resultMap.put("type", "1");
  			}else if(cssForeign == true && cvsForeign != true ){
  				resultMap.put("type", "2");
  			}else{
  				resultMap.put("type", "3");
  			}
  		}
  		//返回视图
  		mav.setViewName("showAllCustomers.jsp");
  		return resultMap;
  	 }
    
    
    
    //admin超级管理员权限可以查看所有的员工信息（经理+员工）这个页面不仅仅是删除，修改，新增都有的
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/deleteEmployee.action")
    @RequiresRoles(value={"admin","manager"},logical=Logical.OR)
    public String getAllEmployeesForDelete(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数2：每页显示数据的条数
        PageHelper.startPage(pn, 5);
        //从当前类下注入的业务层实现类EmployeesService中调用方法，该方法所在类利用注入的EmployeesDao来调用真正的查询方法查询数据库信息。
        List<Employees> allEmployees = es.getAllEmployees();
        System.err.println(allEmployees);
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo<Employees> page = new PageInfo<Employees>(allEmployees,5);
        //利用EmployeesService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
        model.addAttribute("pageInfo", page);
        return "Demo/employee/deleteEmployee.jsp";
    }
  //manager可以查看所有的员工信息不包括经理（员工） 
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
    @RequestMapping(value="/deleteEmployeeNotManager.action")
    @RequiresRoles(value={"manager"},logical=Logical.OR)
    public String getAllEmployeesNotManagerForDelete(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
        //startPage是PageHelper的静态方法，参数1：默认开始页面，参数2：每页显示数据的条数
        PageHelper.startPage(pn, 5);
        //从当前类下注入的业务层实现类EmployeesService中调用方法，该方法所在类利用注入的EmployeesDao来调用真正的查询方法查询数据库信息。
        List<Employees> allEmployees = es.findAllEmployeeNotManager();
        System.err.println(allEmployees);
        //使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
        PageInfo<Employees> page = new PageInfo<Employees>(allEmployees,5);
        //利用EmployeesService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
        model.addAttribute("pageInfo", page);
        return "Demo/employee/deleteEmployee.jsp";
    }
    
    
    
    //增加用户（存在问题增加异常未处理）
    @RequestMapping(value="/addEmployeeForDatabase.action")
    @Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor = RuntimeException.class)
    @RequiresRoles(value={"admin","manager"},logical=Logical.OR)
    public String addEmployees(@Valid Employees emp,Model model) {//这里的emp的`emptype`值是0，1，5
       System.err.println(emp+"=========增加==============");
       if("1".equals(emp.getEmptype())){
    	   emp.setEmptype("经理");
    	   emp.setRoleId(2);
       }else if("2".equals(emp.getEmptype())){
    	   emp.setEmptype("普通员工");
    	   emp.setRoleId(11);
       } 
       //保存用户的时候对账户密码进行加密
       
       Md5Hash md5 = new Md5Hash(emp.getPassword(),emp.getUsername(),1);
       
       emp.setPassword(md5.toString());

       int temp = es.addEmployeeForDatabase(emp);
       System.err.println("增加employee"+temp);
     /*事务测试
       System.out.println(es.addEmployeeForDatabase(new Employees("dongge55","fdsa","1855","dongdd5","5018@qq.com","经理",1))+"===============================");
       try{
    	   int a = 1/0;
       }catch(Exception e){
    	   TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    	   new RuntimeException();
       }*/
       return "redirect:showEmployee.action";
    }
    //删除单个用户
    @RequestMapping(value="/removeOneEmployee.action")
    @RequiresRoles(value={"admin","manager"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  removeOneEmployee(String emp_id,String currentPage,ModelAndView mav){
    	System.err.println("-------------------------removeOneEmployee--------------------------------");
		//得到删除数据的id和当前页
    	int empId = Integer.parseInt(emp_id);
		int temp = es.removeOneEmployeeForDatabse(empId);
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
    @RequestMapping(value="/removeMoreEmployees.action")
    @RequiresRoles(value={"admin","manager"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  removeMoreEmployees(@RequestParam(value ="emp_ids[]") Integer[] emp_ids,String currentPage,ModelAndView mav){
    	//得到删除数据的id和当前页
    	System.err.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    	
    	int temp;
    	boolean test = true;
    	if(emp_ids != null && emp_ids.length!=0){
    		for(int i=0;i<emp_ids.length;i++){
    			temp = es.removeOneEmployeeForDatabse(emp_ids[i]);
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
    
    //修改用户
    @RequestMapping(value="/modifyEmployee.action")
    @RequiresRoles(value={"admin","manager"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  modifyEmployees(@Valid Employees emp,ModelAndView mav){
    	//得到删除数据的id和当前页
    	System.err.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    	System.err.println(emp);
    	if("1".equals(emp.getEmptype())){
      	   emp.setEmptype("经理");
      	   emp.setRoleId(2);
         }else if("2".equals(emp.getEmptype())){
      	   emp.setEmptype("普通员工");
      	   emp.setRoleId(2);
         } 
    	
    	//保存用户的时候对账户密码进行加密
        
        Md5Hash md5 = new Md5Hash(emp.getPassword(),emp.getUsername(),1);
        
        emp.setPassword(md5.toString());
    	
    	int temp = es.modifyEmployeeForDatabse(emp);
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
    
    //重名校验
    @RequestMapping(value="/checkEmployeeName.action")
    @RequiresRoles(value={"admin","manager","employees"},logical=Logical.OR)
	public @ResponseBody Map<String,Object>  checkEmployeeName(String username,ModelAndView mav){
    	System.err.println("--------------------checkEmployeeName:"+username+"-----------------------------");
    	
		//得到删除数据的id和当前页
    	int temp = es.findCountByUsername(username);
		//int temp = es.removeOneEmployeeForDatabse(empId);
		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>(); 
		if (temp == 0) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");	
		}
		//返回视图
		mav.setViewName("deleteEmployee.jsp");
		return resultMap;
	}
    
}
