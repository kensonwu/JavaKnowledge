package com.kenson.map.treemap;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		Person p1 = new Person("曾志伟",10);
		Person p2 = new Person("郭富城",100);
		Person p3 = new Person("黄渤",1);
		Person p4 = new Person("刘德华",500);
		Person p5 = new Person("Kenson",10000);
		
		//存入TreeMap
		//必须提供一个比较器
		TreeMap<Person, String> map = new TreeMap<Person, String>(
				new Comparator<Person>(){

					@Override
					public int compare(Person o1, Person o2) {
						return o1.getHandsome() - o2.getHandsome();
					}
					
				}
				);	
		map.put(p1, "Study");
		map.put(p2, "Study");
		map.put(p3, "Study");
		map.put(p4, "Study");
		map.put(p5, "Study");
		
		//查看键
		Set<Person> persons = map.keySet();
		System.out.println(persons);
	}

}
