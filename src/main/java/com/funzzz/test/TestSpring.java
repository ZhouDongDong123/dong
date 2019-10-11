/*
package com.funzzz.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.funzzz.mapper.CustomershareMapper;
import com.funzzz.model.Customershare;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfig.xml")
public class TestSpring {
	@Autowired
	private CustomershareMapper customershareMapper;
	@Test
	public void test(){
		List<Customershare> list = customershareMapper.selectAll();
		if(list != null){
			for (Customershare customershare : list) {
				System.err.println(customershare);
			}
		}
	}
	
	
	
}
*/
