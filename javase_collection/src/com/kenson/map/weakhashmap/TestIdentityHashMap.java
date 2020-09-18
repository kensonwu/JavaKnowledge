package com.kenson.map.weakhashmap;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap 键比较地址去重
 * @author wuchun
 *
 */
public class TestIdentityHashMap {
	public static void main(String[] args) {
		IdentityHashMap<String, String> map = new IdentityHashMap<String, String>();
		//常量池中的变量， 存在即获取， 此处的a 是常量池中的变量， 所以长度是1
		map.put("a", "Kenson is good!");
		map.put("a", "Kenson is well!");
		System.out.println(map.size());
		//注意：new String("a") 是两个变量不同于常量池中的变量。，所以map的size是3
		map.put(new String("a"), "Kenson is working hard!");
		map.put(new String("a"), "Kenson is learning Java!");
		System.out.println(map.size());
	}
}
