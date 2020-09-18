package com.kenson.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * count one word exear times in this sentence this is a cat and that is a mice
 * and where is the food? 思路： 1.分割字符 2.分拣存储 3.按要求查看单词出现的次数 4. 加入面向对象
 * 
 * @author wuchun
 *
 */
public class TestMap2 {
	public static void main(String[] args) {
		// 分割字符
		String string = "this is a cat and that is a mice and where is the food?";
		String[] arr = string.split(" ");
		// 分拣存储
		Map<String, Letter> map = new HashMap<String, Letter>();
		// 遍历数组
		for (String key : arr) {
			/*
			// 第一次查看是否存在袋子
			if (!map.containsKey(key)) { // 不存在
				map.put(key, new Letter(key));
			}
			// 获取具体的袋子
			Letter value = map.get(key);
			value.setCount(value.getCount() + 1);
			*/
			
			//// 另外一种写法
			Letter value = map.get(key);
			if(null == value){
				value = new Letter();
				map.put(key, value);
			}
			value.setCount(value.getCount() + 1);
		}
		
		/*
		 * // 查看每个单词出现的次数 
		 * Set<String> keySet = map.keySet(); // 获取对象
		 * Iterator<String> it = keySet.iterator(); 
		 * while (it.hasNext()) {
		 * String key = it.next(); 
		 * Letter value = map.get(key);
		 * System.out.println(key + "---------" + value.getCount());
		 * 
		 * }
		 */
		
		/*
		// 查看每个单词出现的次数
		for (String key : map.keySet()) {
			Letter value = map.get(key);
			System.out.println(key + "---------" + value.getCount());
		}
		
		System.out.println("###############################");
		*/
		
		//另外一种遍历的写法
		Set<String> keySet = map.keySet();	//获取对象
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Letter value = map.get(key);
			System.out.println(key + "---------" + value.getCount());
		}

	}
}
