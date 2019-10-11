package com.funzzz.service;

import java.util.List;

public interface RoleService {
	List<String> findRoleNameByUserName(String username);
}
