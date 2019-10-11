package com.funzzz.service;

import java.util.List;

import com.funzzz.model.Permission;

public interface PermissionService {
	List<Permission> findPermissionByParentId(Integer parebtId);
	List<String> findPermissionByUserName(String username);
	//查找所有权限
	List<Permission> findAllPermissions();
	//查找所有权限
	List<Permission> findAllMeuns();
}
