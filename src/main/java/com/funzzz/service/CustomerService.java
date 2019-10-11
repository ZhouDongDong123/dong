package com.funzzz.service;

import java.util.List;

import com.funzzz.model.Customer;
import com.funzzz.model.Employees;

public interface CustomerService {
	//查看所有顾客
	List<Customer> findAllCustomer();
	//通过cid找所有专员
	List<Employees> findEmployeesByCid(Integer cid);
	//增
	int addCustomer(Customer customer);
	//删
	 int removeByPrimaryKey(Integer cid);
	//改
	 int modifyByPrimaryKeySelective(Customer record);
	
	//通过id得到名字
    String findCusNameById(Integer cid);
    //通过专员名字找到所有顾客
    List<Customer> findAllCustomerByUsername(String username);
    //
    Integer findCusIdByName(String cusName);
}
