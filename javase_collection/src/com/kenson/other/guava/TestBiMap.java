package com.kenson.other.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * HashMap, 键唯一， 值可以重复
 * BiMap： 双向Map(Bidirectional Map) 键与值都不能重复（unique - valued map）
 * @author wuchun
 *
 */
public class TestBiMap {
	public static void main(String[] args) {
		BiMap<String, String> biMap = HashBiMap.create();
		biMap.put("xinlang", "xinlang@sina.com");
		biMap.put("qq", "qq@qq.com");
		biMap.put("yahoo", "yahoo@yahoo.com");
		
		//通过邮箱找用户
		String string = biMap.inverse().get("yahoo@yahoo.com");
		System.out.println(string);
		System.out.println(biMap.inverse().inverse()== biMap);
	}

}
