package com.kenson.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * count one word exear times in this sentence
 * this is a cat and that is a mice and where is the food?
 * 思路：
 * 1.分割字符
 * 2.分拣存储
 * 3.按要求查看单词出现的次数
 * @author wuchun
 *
 */
public class TestMap {
	public static void main(String[] args) {
		//分割字符
		String string = "this is a cat and that is a mice and where is the food ?";
		String[] arr = string.split(" ");
		//分拣存储
		Map<String, Integer> map = new HashMap<String, Integer>();
		//遍历数组
		for (String key : arr) {
			//System.out.println(key);	//查看单词
			//查看是否存在这个单词
		/*	if (!map.containsKey(key)) {
				map.put(key, 1);
			}else{	//已经存在
				map.put(key, map.get(key)+1);
			}*/
			//另外一种写法
			Integer value = map.get(key);
			if (null == value) {
				map.put(key, 1);
			}else{
				map.put(key, map.get(key)+1);
			}
		}
		
		//查看每个单词出现的次数
		Set<String> keySet = map.keySet();
		//获取对象
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key + "---------" + value);
			
		}
	}
}
