/**  
 * Project Name:collection  
 * File Name:VectorRandomAccessTest.java  
 * Package Name:com.kenson.collection.vectortest  
 * Date:May 22, 20189:29:54 AM  
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/  
  
package com.kenson.list.vector;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**  
 * ClassName:VectorRandomAccessTest   
 * Function: Vector遍历方式和效率的测试.   
 * 
 *  结论：  Vector使用foreach 效率最高， Iterator效率最低
 *  
 * Date:     May 22, 2018 9:29:54 AM   
 * @author   CHUNWU  
 * @version  0.1  
 * @since    JDK 1.8  
 * @see
 * @link     www.imkenson.com        
 */
public class VectorRandomAccessTest {

	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<Integer>();
		for (int i = 0; i < 100000; i++) {
			vector.add(i);
		}
		
		// 通过Iterator遍历Vector
		iteratorVectorThruIterator(vector);
		//通过普通for遍历Vector
		iteratorVectorThruFor(vector);
		// 通过增强for遍历Vector
		iteratorVectorThruForeach(vector);
		// 通过Enumeration遍历Vector
		iteratorVectorThruEnumeration(vector);
	}

	/**
	 * 通过iterator来遍历Vector 
	 * iteratorVectorThruIterator.
	 * @author CHUNWU
	 * @param vector
	 * @since JDK 1.8
	 */
	public static void iteratorVectorThruIterator(Vector<Integer> vector) {
		if (vector == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		for (Iterator<Integer> itr = vector.iterator(); itr.hasNext();) {
			itr.next();
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorVectorThruIterator: " + interval + "s");
	}
	
	/**
	 * 通过随机访问来遍历Vector， 也就是通过普通的for循环 
	 * iteratorVectorThruIterator.
	 * @author CHUNWU
	 * @param vector
	 * @since JDK 1.8
	 */
	public static void iteratorVectorThruFor(Vector<Integer> vector) {
		if (vector == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		for (int i = 0; i < vector.size(); i++) {
			vector.get(i);
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorVectorThruFor: " + interval + "s");
	}
	
	/**
	 * 通过随机访问增强for循环来遍历Vector， 也就是通过增强的for循环 
	 * iteratorVectorThruIterator.
	 * @author CHUNWU
	 * @param vector
	 * @since JDK 1.8
	 */
	public static void iteratorVectorThruForeach(Vector<Integer> vector) {
		if (vector == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		for (Integer integer: vector) {
			;
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorVectorThruForeach: " + interval + "s");
	}
	
	/**
	 * 通过 枚举 Enumeration 来遍历Vector
	 * iteratorVectorThruIterator.
	 * @author CHUNWU
	 * @param vector
	 * @since JDK 1.8
	 */
	public static void iteratorVectorThruEnumeration(Vector<Integer> vector) {
		if (vector == null) {
			return;
		}

		// 开始记录时间
		long start = System.currentTimeMillis();
		for (Enumeration<Integer> enumeration = vector.elements(); enumeration.hasMoreElements();) {
			enumeration.nextElement();
		}

		// 记录结束时间
		long end = System.currentTimeMillis();
		long interval = end - start;
		System.out.println("iteratorVectorThruEnumeration: " + interval + "s");
	}
}
  
