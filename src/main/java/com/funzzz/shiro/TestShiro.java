/*
package com.funzzz.shiro;



import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;

import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;

import org.apache.shiro.mgt.DefaultSecurityManager;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.funzzz.realm.LoginRealm;

public class TestShiro extends AuthorizingRealm{
	private static DruidDataSource dataSource;
	static {
		dataSource = new DruidDataSource();
		dataSource.setUrl("");
		dataSource.setDriverClassName("");
		dataSource.setUsername("");
		dataSource.setPassword("");
		
	}
	@Test
	public void test(){
		DefaultSecurityManager  securityManager= new DefaultSecurityManager();
		IniRealm realm = new IniRealm("classpath:com/funzzz/shiro/authon.ini");
		securityManager.setRealm(realm);
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
		try{
			subject.login(token);
			System.out.println("认证成功");
			subject.checkPermissions("user:insert");
			
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}catch(UnknownAccountException e){
			System.out.println("账号错误");
		}
	}
	
	@Test
	public void testDB(){
		DefaultSecurityManager  securityManager= new DefaultSecurityManager();
		
//		IniRealm realm = new IniRealm("classpath:com/funzzz/shiro/authon.ini");
		JdbcRealm realm = new JdbcRealm();

		
		securityManager.setRealm(realm);
		
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
		try{
			
			subject.login(token);
			System.out.println("认证成功");
			subject.checkPermissions("user:insert");
			
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}catch(UnknownAccountException e){
			System.out.println("账号错误");
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
	@Test
	public void test4(){
		DefaultSecurityManager  securityManager= new DefaultSecurityManager();
		LoginRealm realm = new LoginRealm();
		securityManager.setRealm(realm);
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("admin","123456");
		try{
			subject.login(token);
			System.out.println("认证成功");
			subject.checkPermissions("user:insert");
			
		}catch(IncorrectCredentialsException e){
			System.out.println("密码错误");
		}catch(UnknownAccountException e){
			System.out.println("账号错误");
		}
	}
	
}
*/
