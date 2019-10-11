package com.funzzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.funzzz.mapper.CustomershareMapper;
import com.funzzz.model.Customershare;
@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class CustomershareServiceImpl implements CustomershareService{
	@Autowired
	CustomershareMapper cm;
	@Override
	public int addCustomershare(Customershare c) {
		// TODO Auto-generated method stub
		return cm.insertSelective(c);
	}
	@Override
	public int removeCustomershareByCidAndEmpId(Customershare customershare) {
		// TODO Auto-generated method stub
		return cm.deleteCustomershareByCidAndEmpId(customershare);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int findPrimaryKeyByCidAndEmpId(Customershare customershare) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKeyByCidAndEmpId(customershare);
	}
	@Override
	public int removeByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cm.deleteByPrimaryKey(id);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int findForeignKeyByCid(Integer cid) {
		// TODO Auto-generated method stub
		return cm.selectForeignKeyByCid(cid);
	}
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int findForeignKeyByEmpId(Integer empId) {
		// TODO Auto-generated method stub
		return cm.selectForeignKeyByEmpId(empId);
	}


}
