package com.funzzz.utils;

import java.util.ArrayList;
import java.util.List;
public class UncheckedCast {
	//用于把obj转为List<T> 消除Unchecked Cast警告
	public static <T> List<T> castList(Object obj, Class<T> clazz){
	    List<T> result = new ArrayList<T>();
	    if(obj instanceof List<?>){
	        for (Object o : (List<?>) obj){
	            result.add(clazz.cast(o));
	        }
	        return result;
	    }
	    return null;
	}
}
