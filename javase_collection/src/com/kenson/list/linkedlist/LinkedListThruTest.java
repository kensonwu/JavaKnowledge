/**  
 * Project Name:collection  
 * File Name:LinkedListThruTest.java  
 * Package Name:com.kenson.collection  
 * Date:May 21, 201811:17:27 AM  
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/

package com.kenson.list.linkedlist;
/**  
 * ClassName:LinkedListThruTest   
 * Function: 测试LinkedList的几种遍历方式和效率    
 * 
 * 结论： 
 * 遍历LinkedList时，使用removeFist()或removeLast()效率最高。但用它们遍历时，会删除原始数据；若单纯只读取，而不删除，
 * 应该使用增强for循环遍历方式。无论如何，千万不要通过随机访问去遍历LinkedList！
 * Date:     May 21, 2018 11:17:27 AM   
 * @author   CHUNWU  
 * @version  0.1  
 * @since    JDK 1.8  
 * @see
 * @link     www.imkenson.com        
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListThruTest {
	public static void main(String[] args) {
		// 通过Iterator遍历LinkedList
		 iteratorLinkedListThruIterator(getLinkedList());
		// 通过快速随机访问遍历LinkedList
		 iteratorLinkedListThruFor(getLinkedList());
		// 通过增强for循环遍历LinkedList
		 iteratorLinkedListThruForeach(getLinkedList());
		// 通过PollFirst遍历LinkedList
		 iteratorLinkedListThruPollFirst(getLinkedList());
		// 通过PollLast遍历LinkedList
		 iteratorLinkedListThruPollLast(getLinkedList());
		// 通过RemoveFirst遍历LinkedList
		iteratorLinkedListThruRemoveFirst(getLinkedList());
		// 通过RemoveLast遍历LinkedList
		 iteratorLinkedListThruRemoveLast(getLinkedList());
	}

	/**
	 * 得到一个linked list 并给他赋值 getLinkedList.
	 * 
	 * @author CHUNWU
	 * @return
	 * @since JDK 1.8
	 */
	public static LinkedList<Integer> getLinkedList() {
		LinkedList<Integer> llist = new LinkedList<>();
		for (int i = 0; i < 100000; i++) {
			llist.addLast(i);
		}
		return llist;
	}

	/**
	 * 通过iterator来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruIterator(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		for (Iterator<Integer> itr = list.iterator(); itr.hasNext();) {
			itr.next();
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruIterator: " + interval + "s");
	}

	/**
	 * 通过随机访问来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruFor(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			list.get(i);
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruFor: " + interval + "s");
	}

	/**
	 * 通过增强for 循环来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruForeach(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		for (Integer integer : list) {
			;
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruForeach: " + interval + "s");
	}

	/**
	 * 通过 pollFirst() 循环来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruPollFirst(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		while (list.pollFirst() != null) {
			;
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruPollFirst: " + interval + "s");
	}

	/**
	 * 通过 pollLast() 循环来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruPollLast(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		while (list.pollLast() != null) {
			;
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruPollLast: " + interval + "s");
	}

	/**
	 * 通过 removeFirst() 循环来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruRemoveFirst(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();

		try {
			while (list.removeFirst() != null) {
				;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruRemoveFirst: " + interval + "s");
	}

	/**
	 * 通过 removeLast() 循环来遍历LinkedList iteratorLinkedListThruIterator: .
	 * 
	 * @author CHUNWU
	 * @param list
	 * @since JDK 1.8
	 */
	public static void iteratorLinkedListThruRemoveLast(LinkedList<Integer> list) {
		if (list == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();

		try {
			while (list.removeLast() != null) {
				;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorLinkedListThruRemoveLast: " + interval + "s");
	}

}
