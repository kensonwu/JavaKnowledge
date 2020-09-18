package com.kenson.other.guava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;

/**
 * 需求： 分析查看教师教授的每门课程
 * MultiMap： key-value	可以重复
 * @author wuchun
 *
 */
public class TestMultiMap {
	public static void main(String[] args) {
		//创建map 对象
		Map<String, String> cours = new HashMap<String, String>();
		//加入测试数据
		cours.put("改革开放", "邓爷爷");
		cours.put("三个代表", "江大爷");
		cours.put("科学发展观", "胡大爷");
		cours.put("和谐社会", "胡大爷");
		cours.put("八荣八耻", "胡大爷");
		cours.put("命运共同体", "习大爷");
		cours.put("一带一路", "习大爷");
		
		//MultiMap
		ArrayListMultimap<String, String> teachers = ArrayListMultimap.create();
		
		//迭代器
		Iterator<Map.Entry<String, String>> it = cours.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String value = entry.getKey();
			String key = entry.getValue();
			
			//教师--->课程
			teachers.put(key, value);
		}
		
		//查看MultiMap
		Set<String> keySet = teachers.keySet();
		for (String key : keySet) {
			Collection<String> col = teachers.get(key);
			System.out.println(key + "------>" +col);
		}
		
		ArrayListMultimap<String, String> test = ArrayListMultimap.create();
		test.put("11", "test");
		test.put("11", "test");
		test.put("11", "test");
		test.put("11", "test");
		test.put("11", "test");
		test.put("11", "test");
		for (String t : test.keySet()) {
			System.out.println(t + "--------" + test.get(t));
		}
		
		
	}

}
