package com.funzzz.service;

import java.util.List;

import com.funzzz.model.Employees;

public interface EmployeesService {
	//增加用户
	public int addEmployeeForDatabase(Employees emp);
	//删除用户通过用户id
	public int removeOneEmployeeForDatabse(int emp_id);
	//修改用户通过模态框
	public int modifyEmployeeForDatabse(Employees emp);
	//查询所有用于分页
	public List<Employees> getAllEmployees();
	//查询所有用于分页
	public List<Employees> getAllEmployeesByCondition(String condition);
	//findSelectedEmployeesOnCunstomer
	public List<Employees> findSelectedEmployeesById(Integer empId);
	//通过用户名查询密码，用于shiro分页，在自定义realm中
	public String getPasswordByUsername(String username);
	//用户登陆查询（这部分查询得到用户的身份，可区分经理和普通员工跳到不同的页面）
	public Employees findEmployeeForLogin(Employees emp);
	//
	public String findUserNameById(Integer empId);
	//通过通过名字修改密码
	public int modifyPasswordByUsername(Employees  employee);
	//
	 Integer findEmpIdByUsername(String username);
	 ////获取所有员工不包括经理用于分页 会被插件拦截的
	 List<Employees> findAllEmployeeNotManager();
	 //
	 Integer findCountByUsername(String username);
}
