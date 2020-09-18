package com.kenson.other.commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

/**
  双向map， 要去键值都不能重复
  接口： BidiMap
  2个实现类： 
  （1）. DualTreeBidiMap: 有序
  （2）. DualHashBidiMap: 无序
  
 * 
 * 
 * @author wuchun
 *
 */
public class TestDoubleDirectionMap {
	public static void main(String[] args) {
		TestDualHashBidiMap();
		TestDualTreeBidiMap();
	}
	
	
	/**
	 * 无序的双向map
	 */
	public static void TestDualHashBidiMap(){
		System.out.println("========无序双向map===========");
		BidiMap<String, String> map = new DualHashBidiMap<String, String>();
		map.put("google", "google.com");
		map.put("yahoo", "yahoo.com");
		//双向map可以通过键找到值， 也可以通过值找到键但是需要反转
		//反转
		System.out.println(map.inverseBidiMap().get("google.com"));
		//遍历查看
		MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
		while (it.hasNext()) {
			System.out.println(it.next() + "----------->" + it.getValue());
		}
	}
	
	/**
	 * 有序的双向map
	 */
	public static void TestDualTreeBidiMap(){
		System.out.println("=========有序双向map==========");
		BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
		map.put("google", "google.com");
		map.put("yahoo", "yahoo.com");
		map.put("alibaba", "alibaba.com");
		map.put("11", "google.com");
		map.put("goog11le", "google.com");
		map.put("goo22gle", "google.com");
		map.put("333", "google.com");
		map.put("goo21313gle", "google.com");
		//双向map可以通过键找到值， 也可以通过值找到键但是需要反转
		//反转
		System.out.println(map.inverseBidiMap().get("google.com"));
		//遍历查看
		MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
		while (it.hasNext()) {
			System.out.println(it.next() + "----------->" + it.getValue());
		}
	}
}
