package com.kenson.other.commons;

import java.util.Iterator;
import java.util.Set;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/*
 
 Bag包允许重复
 1. HashBag： 无序
 2. TreeBag： 有序
 
 应用： 统计单词出现的次数
 
 * 
 * 
 */
public class TestBag {
	public static void main(String[] args) {
		testHashBag();
		testTreeBag();
		countWords();
	}
	
	/**
	 * 无序bag
	 */
	public static void testHashBag(){
		System.out.println("=======无序的包============");
		Bag<String> bag = new HashBag<String>();
		bag.add("a");
		bag.add("d", 5);
		bag.remove("a", 2);
		bag.add("b");
		bag.add("c");
		/*Iterator<String> it = bag.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		for (Iterator<String> it1 = bag.iterator(); it1.hasNext();) {
			System.out.println(it1.next());
		}
	}
	
	/**
	 * 有序bag
	 */
	public static void testTreeBag(){
		System.out.println("=======有序的包============");
		Bag<String> bag = new TreeBag<String>();
		bag.add("f", 5);
		bag.add("a");
		bag.add("b");
		bag.add("c");
		bag.remove("b");
		
		Iterator<String> it = bag.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
			
		}
	}

	public static void countWords(){
		String string = "this is a cat and that is a mice and where is the food?";
		//分割字符串
		String[] strArray = string.split(" ");
		Bag<String> bag = new TreeBag<String>();
		for (String str : strArray) {
			bag.add(str);
		}
		
		System.out.println("===============统计次数==============");
		Set<String> letters = bag.uniqueSet();
		for (String letter : letters) {
			System.out.println(letter + "--------------------->" +bag.getCount(letter));
		}
	}

}
