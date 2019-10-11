package com.funzzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.funzzz.mapper.PermissionMapper;
import com.funzzz.model.Permission;
@Service("permissionService")
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class PermissionServiceImpl implements PermissionService{
	@Autowired
	private PermissionMapper pm;
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Permission> findPermissionByParentId(Integer parebtId) {
		// TODO Auto-generated method stub
		return pm.selectPermissionByParentId(parebtId);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<String> findPermissionByUserName(String username) {
		// TODO Auto-generated method stub
		return pm.selectPermissionByUserName(username);
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
	public List<Permission> findAllPermissions() {
		// TODO Auto-generated method stub
		return pm.selectAllPermissions();
	}

	@Override
	public List<Permission> findAllMeuns() {
		// TODO Auto-generated method stub
		return pm.selectAllMeuns();
	}

}
