package com.funzzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.funzzz.mapper.EmployeesMapper;
import com.funzzz.model.Employees;
@Service("employeesService")
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class EmployeesServiceImpl implements EmployeesService{
	@Autowired
	EmployeesMapper em;
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Employees> getAllEmployees() {
		// TODO Auto-generated method stub
		return em.selectAllEmployee();
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public String getPasswordByUsername(String username) {
		// TODO Auto-generated method stub
		return em.selectPasswordByUserName(username);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public Employees findEmployeeForLogin(Employees emp) {
		// TODO Auto-generated method stub
		return em.selectEmployeeForLogin(emp);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int addEmployeeForDatabase(Employees emp) {
		// TODO Auto-generated method stub
		System.err.println(emp+"==========service-add===============");
		return em.insertSelective(emp);
	}
	@Override
	public int removeOneEmployeeForDatabse(int emp_id) {
		// TODO Auto-generated method stub
		System.err.println(emp_id+"==========service-remove===============");
		return em.deleteByPrimaryKey(emp_id);
	}
	@Override
	public int modifyEmployeeForDatabse(Employees emp) {
		System.err.println("==========service-modify===============");
		return em.updateByPrimaryKeySelective(emp);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public List<Employees> getAllEmployeesByCondition(String condition) {
		// TODO Auto-generated method stub
		return em.selectAllEmployeeByCondition(condition);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Employees> findSelectedEmployeesById(Integer empId) {
		// TODO Auto-generated method stub
		return em.selectEmployeesByPrimaryKey(empId);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public String findUserNameById(Integer empId) {
		// TODO Auto-generated method stub
		return em.selectUserNameById(empId);
	}
	@Override
	public int modifyPasswordByUsername(Employees employee) {
		// TODO Auto-generated method stub
		return em.updatePasswordByUsername(employee);
	}
	@Override
	public Integer findEmpIdByUsername(String username) {
		// TODO Auto-generated method stub
		return em.selectEmpIdByUsername(username);
	}
	@Override
	public List<Employees> findAllEmployeeNotManager() {
		// TODO Auto-generated method stub
		return em.selectAllEmployeeNotManager();
	}
	@Override
	public Integer findCountByUsername(String username) {
		// TODO Auto-generated method stub
		return em.selectCountByUsername(username);
	}

}
