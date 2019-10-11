package com.funzzz.test;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Date;

public class TestMd5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Md5Hash md5 = new Md5Hash("123456","a",1);
		System.err.println(md5);
		System.out.println("fdsjfh".getClass());


	}

}
