package com.funzzz.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.funzzz.service.EmployeesService;
import com.funzzz.service.PermissionService;
import com.funzzz.service.RoleService;
@Component("loginRealm")
public class LoginRealm extends AuthorizingRealm{
	@Autowired
	private EmployeesService es;
	@Resource(name="roleService")
	private RoleService rs;
	@Resource(name="permissionService")
	private PermissionService ps;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName = (String)token.getPrincipal();
		//通过用户名得到角色名

		String password = es.getPasswordByUsername(userName);
		System.err.println(password+"===========来自自定义reaml==================");
		if(password == null){
			return null;
		}else{
			SimpleAuthenticationInfo info;
			info = new SimpleAuthenticationInfo(userName,password,"mytoken");
			System.err.println(info.getPrincipals().toString()+"来自数据库"+info.getCredentials());
			
			//如果加盐需要加下面一句(设置解密)
			info.setCredentialsSalt(ByteSource.Util.bytes(userName));
			
			return info;
			
		}
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		//得到用户名
		String username = (String)principal.getPrimaryPrincipal();
		//通过用户名得到角色名
		Set<String> roles = new HashSet<String>(rs.findRoleNameByUserName(username)) ;
		//通过用户名得到权限名
		Set<String> promissions = new HashSet<String>(ps.findPermissionByUserName(username)) ;
		
		SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
		sai.setStringPermissions(promissions);
		sai.setRoles(roles);
		
		return sai;
		
	}

}
