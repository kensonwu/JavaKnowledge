package com.kenson.map.treemap;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 测试TreeSet
 * 提供了解耦的方式：业务排序类
 * @author wuchun
 *
 */
public class TestTreeSet {
	public static void main(String[] args) {
		Person p1 = new Person("曾志伟",10);
		Person p2 = new Person("郭富城",100);
		Person p3 = new Person("黄渤",1);
		Person p4 = new Person("刘德华",500);
		Person p5 = new Person("Kenson",10000);
		
		//一次存放到TreeSet容器中,使用排序的业务类(匿名内部类)
		TreeSet<Person> personers = new TreeSet<Person>(
				new Comparator<Person>(){

					@Override
					public int compare(Person o1, Person o2) {
						return o1.getHandsome() - o2.getHandsome();
					}
					
				}
				);
		//注意点： TreeSet 在添加数据时排序
		personers.add(p1);
		personers.add(p2);
		personers.add(p2);
		personers.add(p3);
		personers.add(p4);
		personers.add(p5);
		System.out.println(personers);
		
		//改变数据
		/*p4.setHandsome(10);
		p4.setName("曾志伟");
		System.out.println(personers);*/
		//p4与p1数据重复
		
	}

}
