package com.funzzz.service;

import java.util.List;

import com.funzzz.model.Customervisit;

public interface CustomervisitService {
	//外键检测
	int findForeignKeyByCidForCvs(Integer cid);
	//外键检测
	int findForeignKeyByCidForCss(Integer empId);
	//查询所有数据分页
	List<Customervisit> findAllCustomervisit();
	//增
	int addSelective(Customervisit customervisit);
	//删
	int removeByPrimaryKey(Integer id);
	//改
	int modifyByPrimaryKeySelective(Customervisit record);
	 //通过专员名字找到所有访问记录
    List<Customervisit> findAllCustomervisitByUsername(String username);
}
