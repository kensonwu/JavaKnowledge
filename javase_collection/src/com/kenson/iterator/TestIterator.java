package com.kenson.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Test iterator
 * @author wuchun
 *
 */
public class TestIterator {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		//通过索引for循环遍历List
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("#########");
		for (Object object : list) {
			System.out.println(object);
		}
		
		//通过Iterator遍历List
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
			
		}
		
		Set set = new HashSet();
		set.add("Kenson");
		set.add("Jason");
		set.add("Watson");
		
		Iterator iterator = set.iterator();
		//第一种写法
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		
		//另外一种写法
		for (Iterator iterator2 = set.iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			System.out.println(string);
		}
		
		
	}

}
