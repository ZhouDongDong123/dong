package com.funzzz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.funzzz.model.Customer;
import com.funzzz.model.Customershare;
import com.funzzz.model.Employees;
import com.funzzz.service.CustomerService;
import com.funzzz.service.CustomershareService;
import com.funzzz.service.CustomervisitService;
import com.funzzz.service.EmployeesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerContorller {
	//private final Integer myPageSize = 5;
	/**
	 * 使用pageHelper插件实现分页查询
	 * @param pn：pageNum的缩写，表示页数，默认值为1，即首页。
	 * @param model：是MVC里的Model，作用是将用户信息及分页信息存在此model里，以便发送给页面
	 * @return ：返回到视图解析器下的jsp页面
	 */
	public static final int myPageSize = 5;
	@Autowired
	CustomerService cs;
	@Autowired
	EmployeesService es;
	@Autowired
	CustomershareService css;
	@Autowired
	CustomervisitService cvs;


	/**
	 * 使用了showAllCustomers.jsp页面
	 * @param pn
	 * @param model
	 * @return
	 */



	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	@RequestMapping(value="/findAllCustomers.action")
	@RequiresRoles(value={"admin","manager"},logical=Logical.OR)
	public String findAllCustomers(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
		System.err.println("================================findAllCustomers进来了=====================================");
		//startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
		PageHelper.startPage(pn, 5);
		//从当前类下注入的业务层实现类CustomersService中调用方法，该方法所在类利用注入的CustomersDao来调用真正的查询方法查询数据库信息。
		List<Customer> allCustomers = cs.findAllCustomer();

		String empNames="";
		List<Employees> empList;
		for (Customer customer : allCustomers) {
			empList = customer.getList();
			for (Employees e : empList) {
				empNames+=e.getUsername()+",";
			}
			if(!"".equals(empNames)){
				String temp = empNames.substring(0,empNames.length()-1);
				customer.setUsername(temp);
			}
			System.err.println(customer+"-----------------------------");
			empNames="";
		}
		//使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
		PageInfo<Customer> page = new PageInfo<Customer>(allCustomers,5);
		//利用CustomersService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
		model.addAttribute("pageInfo", page);
		return "Demo/customer/showAllCustomers.jsp";
	}


	@RequestMapping(value="/findmyCustomers.action")
	@RequiresRoles(value={"employee"},logical=Logical.OR)
	public String findmyCustomers(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model,HttpSession session) {
		System.err.println("================================findmyCustomers进来了=====================================");
		//startPage是PageHelper的静态方法，参数1：默认开始页面，参数5：每页显示数据的条数
		PageHelper.startPage(pn, 5);
		//从当前类下注入的业务层实现类CustomersService中调用方法，该方法所在类利用注入的CustomersDao来调用真正的查询方法查询数据库信息。
		Employees emp = (Employees) session.getAttribute("user");
		//通过emp员工找所有顾客
		List<Customer> allCustomers = null;
		if(emp  != null){
			allCustomers = cs.findAllCustomerByUsername(emp.getUsername());
		}
		String empNames="";
		List<Employees> empList;
		for (Customer customer : allCustomers) {
			empList = customer.getList();
			for (Employees e : empList) {
				empNames+=e.getUsername()+",";
			}
			if(!"".equals(empNames)){
				String temp = empNames.substring(0,empNames.length()-1);
				customer.setUsername(temp);
			}
			System.err.println(customer+"-----------------------------");
			empNames="";
		}
		//使用PageInfo包装查询页面，封装了详细的分页信息.第二个参数表示连续显示的页数
		PageInfo<Customer> page = new PageInfo<Customer>(allCustomers,5);
		//利用CustomersService属性，将分页的信息以及查询出来的信息封装到model里，传送给页面
		model.addAttribute("pageInfo", page);
		return "Demo/customer/showMyCustomers.jsp";
	}


	//初始化页面专员信息，供给经理自由的分配专员
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	@RequestMapping(value="/findAllEmployeesOnCunstomer.action")
	@RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
	public @ResponseBody List<Employees> findAllEmployees() {
		System.err.println("================================findAllEmployeess进来了=====================================");
		List<Employees> list = es.getAllEmployees();
		return list;
	}
	//根据cid查到已经所属的专员用来给页面checkBox初始化选中值
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	@RequestMapping(value="/findSelectedEmployeesOnCunstomer.action")
	@RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
	public @ResponseBody List<Employees> findSelectedEmployeesOnCunstomer(Integer cid) {
		System.err.println("================================findSelectedEmployeesOnCunstomer进来了=====================================");
		System.err.println(cid);
		List<Employees> list  = cs.findEmployeesByCid(cid);
		return list;
	}
	public boolean juageArr(Integer[] arr,Integer value){
		if(arr!=null){
			for (Integer i : arr) {
				if(value.equals(i) ){
					return true;
				}
			}
		}
		return false;
	}
	public boolean juageList(List<Employees> list,Integer value){
		if(list != null){
			if(list.size()!=0){
				for (Employees e : list) {
					if(value.equals(e.getEmpId())){
						return true;
					}
				}
			}
		}
		return false;
	}
	//管理员分配专员
	@RequestMapping(value="/modifyEmployeesDoThing.action")
	@RequiresRoles(value={"admin","manager","employee"},logical=Logical.OR)
	public @ResponseBody Map<String,Object> modifyEmployeesDo(@RequestParam(value="cid",defaultValue="1")Integer cid,@RequestParam(value ="emp_ids[]") Integer[] emp_ids,@RequestParam(value="currentPage",defaultValue="1")Integer pageNum,ModelAndView mav){
		System.err.println("================================modifyEmployeesDo进来了=====================================");
		//1、通过cid查找该顾客选择的有的专员
		boolean test = true;
		List<Employees> employeesList = cs.findEmployeesByCid(cid);
		//3、遍历选中的专员id 如果在 已经在专员id集合内（不做任何事）不在的话共享表加上（add）也就是把这个顾客分给这些员工
		for (Employees employees : employeesList) {
			System.err.println(cid+""+employees+"--------------------->employees");
		}
		if(employeesList == null || employeesList.size()==0){
			for(int i=0;i<emp_ids.length;i++){
				//
				System.err.println("*******************************************************************"+emp_ids[i]);
				int temp1 =  css.addCustomershare(new Customershare(cid,emp_ids[i]));
				if(temp1 != 1){
					test = false;
					break;
				}
			}
		}else{
			for(int i=0;i<emp_ids.length;i++){
				//
				System.err.println("************************************employeesList!=null*******************************"+emp_ids[i]);
				if(!juageList(employeesList, emp_ids[i])){
					//如果不在把该用户add到共享表  emp_ids[i] emp_id
					System.err.println(" --------------temp1-------------"+cid+"--------"+emp_ids[i]);
					int temp1 =  css.addCustomershare(new Customershare(cid,emp_ids[i]));

					if(temp1 != 1){
						test = false;
						break;
					}
				}
			}
		}




		//4、遍历已经有的专员id集，如果专员id 不在选中的id内（移除该员工），在的话共享表（不做任何事）
		if(employeesList != null){
			for (Employees employees : employeesList) {
				if(!juageArr(emp_ids,employees.getEmpId())){
					//从共享表移除该专员
					int id = css.findPrimaryKeyByCidAndEmpId(new Customershare(cid,employees.getEmpId()));
					int temp = css.removeByPrimaryKey(id);
					if(temp!=1){
						test = false;
						break;
					}
				}
			}
		}
		//int temp = es.removeOneEmployeeForDatabse(empId);
		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if (test == true) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");
		}
		//返回视图
		mav.setViewName("showAllCustomers.jsp");
		return resultMap;
	}
	//removeAllEmployeesDo
	//管理员分配专员
	@RequestMapping(value="/removeAllEmployeesDo.action")
	public @ResponseBody Map<String,Object> removeAllEmployeesDo(@RequestParam(value="cid",defaultValue="0")Integer cid,ModelAndView mav){
		System.err.println("================================removeAllEmployeesDo进来了=====================================");
		//1、通过cid查找该顾客选择的有的专员
		boolean test = true;
		List<Employees> employeesList = cs.findEmployeesByCid(cid);
		//4、遍历已经有的专员id集，全部删除
		if(employeesList != null){
			for (Employees employees : employeesList) {
				int id = css.findPrimaryKeyByCidAndEmpId(new Customershare(cid,employees.getEmpId()));
				int temp = css.removeByPrimaryKey(id);
				if(temp!=1){
					test = false;
					break;
				}
			}
		}
		//int temp = es.removeOneEmployeeForDatabse(empId);
		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if (test == true) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");
		}
		//返回视图
		mav.setViewName("showAllCustomers.jsp");
		return resultMap;
	}


	//为移除做准备 外键检查
	@RequestMapping(value="/removeOneCustomerReady.action")
	public @ResponseBody Map<String,Object> removeOneCustomerReady(@RequestParam(value="cid",defaultValue="0")Integer cid,@RequestParam(value="currentPage",defaultValue="1")Integer pageNum,ModelAndView mav){
		System.err.println("================================removeOneCustomerReady进来了=====================================");
		//1、这里应该去查两个表的外键
		//1）先去共享表 如果该表通过cid查出来数量大于0 那就不能删除提示用户外键
		int cssCount = css.findForeignKeyByCid(cid);

		//2）再去访问 如果该表通过cid查出来数量大于0 那就不能删除提示用户外键
		int cvsCount = cvs.findForeignKeyByCidForCvs(cid);
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


	//删除
	@RequestMapping(value="/removeOneCustomer.action")
	public @ResponseBody Map<String,Object> removeOneCustomer(@RequestParam(value="cid",defaultValue="0")Integer cid,@RequestParam(value="currentPage",defaultValue="1")Integer pageNum,ModelAndView mav){
		System.err.println("================================removeOneCustomer进来了=====================================");
		//删除操作还没做
		int temp = cs.removeByPrimaryKey(cid);//
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if (temp == 1) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");
		}
		//返回视图
		mav.setViewName("showAllCustomers.jsp");
		return resultMap;
	}
	//增加顾客（存在问题增加异常未处理）
	@RequestMapping(value="/addCustomerForDatabase.action")
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false,rollbackFor = RuntimeException.class)
	public String addCustomerForDatabase(Customer customer,String username,Model model,HttpSession session) {//这里的emp的`emptype`值是0，1，5
		//此时有可能登陆的管理员或专员专员只能增加自己的专员
		//如果是专员的话那么username就不会是null，所以可以用来判断
		int temp=0;
		if(username!=null){
			//专员不仅要增加一个顾客同时应该在自己的顾客中增加该顾客
			System.err.println(customer+"=========专员增加==============");
			/*
			 * 1、加入该顾客在顾客表中
			 * 2、在customershare表中加入该用户
			 */
			temp = cs.addCustomer(customer);
			//new Customershare(); cid,empId
			//empId 通过 username查到
			Integer empId = es.findEmpIdByUsername(username);
			//cid 加入之后机有可以通过回填或再次查询
			Integer cid = cs.findCusIdByName(customer.getCusname());
			Customershare c = new Customershare (cid,empId);
			temp = css.addCustomershare(c);//在customershare表中加入该用户
		}else{
			System.err.println(customer+"=========管理员增加==============");
			temp = cs.addCustomer(customer);
		}
		System.err.println(temp);
		//普通专员跳到findMyCustomers
		//经理redirect:findAllCustomers.action
		Employees emp = (Employees) session.getAttribute("user");
		if(emp.getEmptype().equals("普通员工")){
			return "redirect:findmyCustomers.action";
		}else{
			return "redirect:findAllCustomers.action";
		}

	}
	//
	//修改顾客
	@RequestMapping(value="/modifycustomer.action")
	public @ResponseBody Map<String,Object>  modifycustomer(Customer customer,ModelAndView mav){
		//得到删除数据的id和当前页
		System.err.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		System.err.println(customer);

		int temp = cs.modifyByPrimaryKeySelective(customer);
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



	//修改顾客
	@RequestMapping(value="/modifySystemPassword.action")
	public @ResponseBody Map<String,Object>  modifySystemPassword(String db_oldPassword,String oldPassword,String newPassword,String confirm,HttpSession session,ModelAndView mav){
		//得到删除数据的id和当前页
		System.err.println("-----------------------modifySystemPassword------------------------------");
		System.err.println(db_oldPassword+"--->"+oldPassword+"--->"+newPassword +"--->"+confirm  );

		//这里应该验证
		/*
		 * 1、db_oldPassword == oldPassword加密
		 * 2、 newPassword == confirm
		 * 3、修改该用户密码
		 */
		//这里应该对旧密码加密后与数据库密码比较然后修改
		//session中的到用户名
		Employees user = (Employees) session.getAttribute("user");
		System.err.println("=========================>"+user);
		int temp = 1;
		Md5Hash md5 = new Md5Hash(oldPassword,user.getUsername(),1);

		if(!db_oldPassword.equals(md5.toString())){
			temp = 0 ;
		}else if(!newPassword.equals(confirm) ){
			temp = 0 ;
		}

		Md5Hash newMd5 = new Md5Hash(newPassword,user.getUsername(),1);
		//这里是新登陆用户名和新密码
		temp = es.modifyPasswordByUsername(new Employees(user.getUsername(),newMd5.toString()));


		//返回判断是否成功
		Map<String,Object> resultMap = new HashMap<String, Object>();
		if (temp == 1) {
			resultMap.put("type", "success");
		}else{
			resultMap.put("type", "err");
		}
		//返回视图
		mav.setViewName("Demo/system/info.jsp");
		return resultMap;
	}


}
