/**  
 * Project Name:collection  
 * File Name:FastFailTest.java  
 * Package Name:com.kenson.collection  
 * Date:May 19, 20181:16:16 PM  
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/  
  
package com.kenson.list.arraylist;
/**  
 * ClassName:FastFailTest   
 * Function: java集合中Fast-Fail的测试程序。   
 * fast-fail事件产生的条件：当多个线程对Collection进行操作时，若其中某一个线程通过iterator去遍历集合时，
 * 该集合的内容被其他线程所改变；则会抛出ConcurrentModificationException异常。
 * fast-fail解决办法：通过util.concurrent集合包下的相应类去处理，则不会产生fast-fail事件。
 * 
 * 本例中，分别测试ArrayList和CopyOnWriteArrayList这两种情况。ArrayList会产生fast-fail事件，而CopyOnWriteArrayList不会产生fast-fail事件。
 * 
 * (01) 使用ArrayList时，会产生fast-fail事件，抛出ConcurrentModificationException异常；定义如下：
 * 		 private static List<String> list = new ArrayList<String>();
 * (02) 使用时CopyOnWriteArrayList，不会产生fast-fail事件；定义如下：
 * 		private static List<String> list = new CopyOnWriteArrayList<String>();
 * 
 * Date:     May 19, 2018 1:16:16 PM   
 * @author   CHUNWU  
 * @version  0.1  
 * @since    JDK 1.8  
 * @see
 * @link     www.imkenson.com        
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FastFailTest {
	
	private static List<String> list = new ArrayList<String>();
	
//	private static List<String> list = new CopyOnWriteArrayList<String>();
	
	public static void main(String[] args) {
		// 同时启动两个线程去操作list
		new threadOne().start();
		new threadTwo().start();
	}
	
	public static void printAll() {
		System.out.println("");
		String value = null;
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			value = iterator.next();
			System.out.print(value + ", ");
		}
	}
	
	/**
	 * 
	 * ClassName: threadOne   
	 * Function: 定义一个静态内部类.
	 * 向list中依次加0,1,2,3,4,5 每添加一个数值后，就通过printAll()遍历整个list  
	 * date: May 19, 2018 1:25:31 PM   
	 *  
	 * @author CHUNWU  
	 * @version 1.0  
	 * @since JDK 1.8
	 */
	public static class threadOne extends Thread{
		@Override
		public void run() {
			  int i = 0;
			  while (i<6) {
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
		}
	}
	
	/**
	 * 
	 * ClassName: threadTwo   
	 * Function: 向list中依次添加10,11,12,13,14,15，每添加一个数之后，就通过printAll()遍历整个list
	 * date: May 19, 2018 1:27:05 PM   
	 *  
	 * @author CHUNWU  
	 * @version 1.0  
	 * @since JDK 1.8
	 */
	public static class threadTwo extends Thread{
		@Override
		public void run() {
			  int i = 10;
			  while (i< 16) {
				list.add(String.valueOf(i));
				printAll();
				i++;
			}
		}
	}

}
  

