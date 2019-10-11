package com.funzzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funzzz.mapper.RoleMapper;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper rm;
	
	@Override
	public List<String> findRoleNameByUserName(String username) {
		// TODO Auto-generated method stub
		return rm.selectRoleNameByUserName(username);
	}

}
