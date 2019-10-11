package com.funzzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.funzzz.mapper.CustomervisitMapper;
import com.funzzz.model.Customervisit;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomervisitServiceImpl implements CustomervisitService{
	@Autowired
	CustomervisitMapper cvm;
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public int findForeignKeyByCidForCvs(Integer cid) {
		// TODO Auto-generated method stub
		return cvm.selectForeignKeyByCidForCvs(cid);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Customervisit> findAllCustomervisit() {
		// TODO Auto-generated method stub
		return cvm.selectAllCustomervisit();
	}

	@Override
	public int addSelective(Customervisit customervisit) {
		// TODO Auto-generated method stub
		return cvm.insertSelective(customervisit);
	}

	@Override
	public int removeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cvm.deleteByPrimaryKey(id);
	}

	@Override
	public int modifyByPrimaryKeySelective(Customervisit record) {
		// TODO Auto-generated method stub
		return cvm.updateByPrimaryKeySelective(record);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public int findForeignKeyByCidForCss(Integer empId) {
		// TODO Auto-generated method stub
		return cvm.selectForeignKeyByCidForCss(empId);
	}

	@Override
	public List<Customervisit> findAllCustomervisitByUsername(String username) {
		// TODO Auto-generated method stub
		return cvm.selectAllCustomervisitByUsername(username);
	}

}
