package com.kenson.genericadvance;

import java.util.ArrayList;
import java.util.List;

/**
 * ?   ---  通配符， 类型不确定， 只能用于变量的声明| 形参 上
 * 不能用于 ： 创建对象， 创建泛型类， 方法 接口
 * 
 * 
 * @author wuchun
 *
 */
public class WildCards {
	public static void main(String[] args) {
		//声明
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();
		list = new ArrayList<Object>();
		
		test(list);
		//编译错误， 不能用在创建对象上
//		list = new ArrayList<?>();
	}
	
	public static void test(List<?> list){
		
	}
	
	/*
	 //不能用在创建泛型类上
	class test2<?>{
		
	}*/
}
