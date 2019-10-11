package com.funzzz.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {
	private static final Class<SqlSessionFactoryUtils> lock = SqlSessionFactoryUtils.class;
	private static SqlSessionFactory sqlSessionFactory = null;
	private SqlSessionFactoryUtils(){}
	public static SqlSessionFactory getSqlSessionFactory(){
		synchronized(lock){
			if(sqlSessionFactory != null){
				return sqlSessionFactory;
			}
			InputStream inputStream;
			String resource = "sqlMapConfig.xml";
			
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		return sqlSessionFactory;
		}
	}
	
	public static SqlSession openSqlSession(){
		if(sqlSessionFactory == null){
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession();
	}
	public static SqlSession openSqlSessionForBatch(){
		if(sqlSessionFactory == null){
			getSqlSessionFactory();
		}
		return sqlSessionFactory.openSession(ExecutorType.BATCH);
	}
	
	
}
