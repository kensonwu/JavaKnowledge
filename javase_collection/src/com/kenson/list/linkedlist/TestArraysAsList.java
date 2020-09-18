/**  
 * Project Name:collection  
 * File Name:TestArraysAsList.java  
 * Package Name:com.kenson.collection.LinkedListTest  
 * Date:2020年3月8日上午10:02:32  
 * Copyright (c) 2020, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/  
  
package com.kenson.list.linkedlist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**  
 * ClassName:TestArraysAsList
 * Date:     2020年3月8日 上午10:02:32   
 * @author   CHUNWU  
 * @version  0.1  
 * @since    JDK 1.8  
 * @see
 * @link     www.imkenson.com        
 */
public class TestArraysAsList {
	
	public static void main(String[] args) {
		List<Integer> tempList = Arrays.asList(1, 2, 4, 5);
//		if (tempList != null && !tempList.isEmpty()) {
//			tempList.add(100);
//		}
		
		Integer[] arr = {1,2,3,4};
		List<Integer> list1 = Arrays.asList(arr);
		System.out.println(list1.size());
		
		// Java 8 实现
		int[] intArr = {1, 2, 3};
		List<Object> list2 = Arrays.stream(intArr)
								.boxed()
								.collect(Collectors.toList());
		list2.add("bb");
		System.out.println(list2);
	}

}
  
