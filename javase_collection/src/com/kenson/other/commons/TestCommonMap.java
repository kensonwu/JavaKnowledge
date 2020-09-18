package com.kenson.other.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.iterators.ArrayListIterator;
import org.apache.commons.collections4.iterators.FilterIterator;
import org.apache.commons.collections4.iterators.LoopingListIterator;
import org.apache.commons.collections4.iterators.UniqueFilterIterator;
import org.apache.commons.collections4.map.HashedMap;


/**
 * 迭代器的扩展
 * 1. MapIterator 以后不再使用map.KeySet.iterator访问
 * IterableMap HashedMap
 * 2. UniqueFilterIterator 去重迭代器
 * 3. FilterIterator 自定义过滤器 + Predicate
 * 4. LoopIterator 循环迭代器
 * @author wuchun
 *
 */
public class TestCommonMap {
	public static void main(String[] args) {
		mapIterator();
		uniqueFilterIterator();
		selfFilterIterator();
		loopIterator();
		arrayIterator();
	}
	
	/**
	 * map迭代器
	 */
	public static void mapIterator(){
		System.out.println("========map迭代器============");
		IterableMap<String, String> map = new HashedMap<>();
		map.put("a", "animal");
		map.put("b", "bag");
		map.put("c", "cat");
		
		//使用IterableMap遍历
		MapIterator<String, String> iterableMap = map.mapIterator();
		while (iterableMap.hasNext()) {
			//必须要有iterableMap.next();
			String key = iterableMap.next();
			String value = iterableMap.getValue();
			System.out.println(key + "---------->" + value);
		}
	}
	
	/*
	 * 去重迭代器
	 */
	public static void uniqueFilterIterator(){
		System.out.println("========去重迭代器============");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("B");
		list.add("a");
		Iterator<String> it = new UniqueFilterIterator(list.iterator());
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 自定义过滤器
	 */
	public static void selfFilterIterator(){
		System.out.println("========自定义迭代器============");
		List<String> list = new ArrayList<>();
		list.add("refer");
		list.add("dad");
		list.add("moom");
		list.add("ken");
		list.add("kek");
		//自定义条件判断
		Predicate<String> pre = new Predicate<String>() {
			
			@Override
			public boolean evaluate(String value) {
				//回文判断
				return new StringBuilder(value).reverse().toString().equals(value);
			}

		};
		
		//使用FilterIterator
		Iterator<String> it = new FilterIterator(list.iterator(), pre);
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * 循环迭代器
	 */
	public static void loopIterator(){
		System.out.println("========循环迭代器============");
		List<String> list = new ArrayList<>();
		list.add("refer");
		list.add("dad");
		list.add("moom");
		list.add("ken");
		list.add("kek");
		Iterator iterator = new LoopingListIterator(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(iterator.next());
		}
	}
	
	/**
	 * 数组迭代器
	 */
	public static void arrayIterator(){
		System.out.println("========数组迭代器============");
		int[] arr = {1,2,3,4,5};
		Iterator iterator = new ArrayListIterator(arr);
		//指定索引到截止索引
		Iterator iterator1 = new ArrayListIterator(arr,1,3);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(iterator.next());
		}
		System.out.println("========指定索引数组遍历============");
		while (iterator1.hasNext()) {
			System.out.println(iterator1.next());
		}
	}
	
}
