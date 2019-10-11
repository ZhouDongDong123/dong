package com.funzzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.funzzz.mapper.CustomerMapper;
import com.funzzz.model.Customer;
import com.funzzz.model.Employees;
@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerMapper cm;
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return cm.selectAllCustomer();
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Employees> findEmployeesByCid(Integer cid) {
		// TODO Auto-generated method stub
		return cm.selectEmployeesByCid(cid);
	}
	@Override
	//增
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return cm.insertSelective(customer);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public String findCusNameById(Integer cid) {
		// TODO Auto-generated method stub
		return cm.selectCusNameById(cid);
	}
	//删
	@Override
	public int removeByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return cm.deleteByPrimaryKey(cid);
	}
	//改
	@Override
	public int modifyByPrimaryKeySelective(Customer record) {
		// TODO Auto-generated method stub
		return cm.updateByPrimaryKeySelective(record);
	}
	@Override
	public List<Customer> findAllCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return cm.selectAllCustomerByUsername(username);
	}
	@Override
	public Integer findCusIdByName(String cusName) {
		// TODO Auto-generated method stub
		return cm.selectCusIdByName(cusName);
	}

}
