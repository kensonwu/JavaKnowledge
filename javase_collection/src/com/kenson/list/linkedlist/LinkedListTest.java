/**  
 * Project Name:collection  
 * File Name:LinkedListTest.java  
 * Package Name:com.kenson.collection.LinkedListTest  
 * Date:May 21, 201811:53:10 AM  
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/

package com.kenson.list.linkedlist;

import java.util.LinkedList;
import java.util.Vector;

/**
 * ClassName:LinkedListTest Function: 测试 LinkedList的常用用法. Date: May 21, 2018
 * 11:53:10 AM
 * 
 * @author CHUNWU
 * @version 0.1
 * @since JDK 1.8
 * @see
 * @link www.imkenson.com
 */
public class LinkedListTest {
	public static void main(String[] args) {
		// 测试LinkedList的API
		testLinkedListAPIs();

		// 将LinkedList 当作LIFO(后进先出)的堆栈
		useLinkedListAsLIFO();

		// 将LinkedList当作 FIFO(先进先出)的队列
		useLinkedListAsFIFO();
	}

	/**
	 * 测试LinkedList中部分的API testLinkedListAPIs: .
	 * 
	 * @author CHUNWU
	 * @since JDK 1.8
	 */
	public static void testLinkedListAPIs() {
		String val = null;
		// 新建一个LinkedList
		LinkedList<Object> list = new LinkedList<>();

		// ------ 添加操作 ---------
		list.add("1");
		list.add(2);
		list.add("3");

		// 将“4”添加到第一个位置
		list.add(1, "4");

		System.out.println("\nTest \"addFirst(), removeFirst(), getFirst()\"");

		// 将“10”添加到第一个位置。 失败的话，抛出异常！
		list.addFirst("10");
		System.out.println("list ---> " + list);

		// 将第一个元素删除。 失败的话，抛出异常！
		System.out.println("list.removeFirst() -->" + list.removeFirst());
		System.out.println(list);

		// 获取一个元素 如果失败则异常
		System.out.println("list getFirst() : ---> " + list.getFirst());

		System.out.println("\nTest \"offerFirst(), pollFirst(), peekFirst()\"");

		// 将"20" 添加到第一个位置。 返回true
		System.out.println(list.offerFirst("20"));
		System.out.println("list --> " + list);

		// 将第一个元素删除， 如果失败， 返回null
		System.out.println("list.pollFirst(): " + list.pollFirst());
		System.out.println("list --> " + list);

		// 获取第一个元素， 失败返回null
		System.out.println("list.peekFirst(): " + list.peekFirst());

		System.out.println("\nTest \"addLast(), removeLast(), getLast()\"");
		// 将"30" 添加到最后一个位置， 失败则异常
		list.addLast("30");
		System.out.println("list --> " + list);

		// 将最后一个元素删除， 失败则异常
		System.out.println("list.removeLast() " + list.removeLast());
		System.out.println("list --> " + list);

		// 获取最后一个元素， 失败则异常
		System.out.println("list.getLast() " + list.getLast());

		System.out.println("\nTest \"offerLast(), pollLast(), peekLast()\"");
		// 将"50" 添加到最后一个位置， 返回true
		System.out.println("list.offerLast() " + list.offerLast("50"));
		System.out.println("list ---> " + list);

		// 将最后一个元素删除， 失败则null
		System.out.println("list.pollLast() " + list.pollLast());
		System.out.println("list ---> " + list);

		// 获取最后一个元素， 失败则null
		System.out.println("list.peekLast() " + list.peekLast());
		System.out.println("list ---> " + list);

		// 将第三个元素设置为 300， 不建议使用此操作， 因为效率很低
		list.set(2, "300");
		System.out.println("list ---> " + list);

		// 获取第3个元素。不建议在LinkedList中使用此操作，因为效率低！
		System.out.println("\nget(3):" + list.get(2));

		// // ---- toArray(T[] a) ----
		// 将LinkedList转为数组
		String[] arr = (String[]) list.toArray(new String[0]);

		for (String str : arr) {
			System.out.println("str ---> " + str);
		}

		// 获取list的大小
		System.out.println("list size: " + list.size());

		// 清空LinkedList
		list.clear();

		// 判断LinkedList是否为空
		System.out.println("isEmpty(): " + list.isEmpty());
	}

	/**
	 * 将LinkedList 当作LIFO(后进先出)的堆栈 useLinkedListAsLIFO: .
	 * 
	 * @author CHUNWU
	 * @since JDK 1.8
	 */
	public static void useLinkedListAsLIFO() {
		System.out.println("------------useLinkedListAsLIFO --------------");
		LinkedList<Object> stack = new LinkedList<Object>();

		// 将1， 2， 3， 4push进LinkedList(堆栈)中
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		stack.push("5");

		// 打印一下 堆栈
		System.out.println("list ---->   " + stack); // list ----> [5, 4, 3, 2, 1]

		// 删除 栈顶 元素
		System.out.println("list.pop()  " + stack.pop());
		System.out.println("list ---->   " + stack); // list ----> [4, 3, 2, 1]

	}

	/**
	 * 将LinkedList当作 FIFO(先进先出)的队列 useLinkedListAsFIFO: .
	 * 
	 * @author CHUNWU
	 * @since JDK 1.8
	 */
	private static void useLinkedListAsFIFO() {
		System.out.println("------------useLinkedListAsFIFO --------------");
		LinkedList<Object> queue = new LinkedList<Object>();

		// 将10,20,30,40添加到队列。每次都是插入到末尾
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);

		// 打印队列
		System.out.println("queue ----> " + queue); // queue ----> [10, 20, 30, 40]

		// 删除队列的第一个元素
		System.out.println(queue.remove());

		// 读取(队列的第一个元素)
		System.out.println("queue.element()  " + queue.element());

		// 打印队列
		System.out.println("queue ----> " + queue); // queue ----> [20, 30, 40]
		
		Vector<Object> vector = new Vector<Object>();
	}
}
