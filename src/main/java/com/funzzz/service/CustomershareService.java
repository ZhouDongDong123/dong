package com.funzzz.service;

import com.funzzz.model.Customershare;

public interface CustomershareService {
	public int addCustomershare(Customershare c);
	
	public int removeCustomershareByCidAndEmpId(Customershare customershare);
	public int findPrimaryKeyByCidAndEmpId(Customershare customershare);
	//
	public int removeByPrimaryKey(Integer id);
	//外键检测
	int findForeignKeyByCid(Integer cid);
	//外键检测
	int findForeignKeyByEmpId(Integer empId);
}
