package com.kenson.map.hashmap;

import com.kenson.bean.Wife;

import java.util.LinkedList;

/**
 * 自定义map的升级版 1. 提高查询效率
 * 
 * @author wuchun
 *
 */
public class MyMapAdvance {
	LinkedList[] arr = new LinkedList[999];
	int size;

	public void put(Object key, Object value) {
		MyEntry e = new MyEntry(key, value);
		
		int hash = key.hashCode();
		hash = hash < 0? -hash : hash;
		int a = hash % arr.length;
		if (arr[a] == null) {
			LinkedList list = new LinkedList();
			arr[a] = list;
			list.add(e);

		} else {
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				MyEntry e2 = (MyEntry) list.get(i);
				if(e2.key.equals(key)){
					e2.value = value;	//deal the duplicate key value situation, replace the value
				}
			}
			
			arr[a].add(e);
		}
	}
	
	public Object get(Object key) {
		int a = key.hashCode() % arr.length;
		if (arr[a] != null) {
			LinkedList list = arr[a];
			for (int i = 0; i < list.size(); i++) {
				MyEntry e = (MyEntry) list.get(i);
				if(e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		MyMapAdvance myMap = new MyMapAdvance();
		myMap.put("Ken", new Wife("Jan"));
		myMap.put("Ken", new Wife("Arvil"));
		myMap.put("Jan", new Wife("Obama"));
		Wife w = (Wife) myMap.get("Ken");
		
		System.out.println(w.getName());
	}

}
