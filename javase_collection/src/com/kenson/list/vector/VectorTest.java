/**  
 * Project Name:collection  
 * File Name:VectorTest.java  
 * Package Name:com.kenson.collection.vectortest  
 * Date:May 22, 201810:17:13 AM  
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/

package com.kenson.list.vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * ClassName:VectorTest Function: Vector测试函数：遍历Vector和常用API. Date: May 22, 2018
 * 10:17:13 AM
 * 
 * @author CHUNWU
 * @version 0.1
 * @since JDK 1.8
 * @see
 * @link www.imkenson.com
 */
public class VectorTest {
	public static void main(String[] args) {
		// 新建一个Vector
		Vector<Object> vector = new Vector<>();

		// 添加元素
		vector.add("1");
		vector.add(2);
		vector.add("Good morning");
		vector.add(5);

		// 设置第一个元素为 first
		vector.set(0, "first");

		// 将500 插入到第3个位置
		vector.add(2, 500);

		System.out.println("vector ---> " + vector);

		// 顺序查找 获取5的索引
		System.out.println("vector .indexOf(5) ---> " + vector.indexOf(5));

		// 倒序查找 获取5的索引
		System.out.println("vector.lastIndexOf(5) ---> " + vector.lastIndexOf(5));

		// 获取第一个元素
		System.out.println("vector.firstElement() ---> " + vector.firstElement());

		// 获取第3个元素
		System.out.println("vector.elementAt(2) ---> " + vector.elementAt(2));

		// 获取最后一个元素
		System.out.println("vector.lastElement() ---> " + vector.lastElement());

		// 获取vector的大小
		System.out.println("vector.size() ---> " + vector.size());

		// 获取vector的总的容量
		System.out.println("vector.capacity() ---> " + vector.capacity());

		// 获取vector的第2个到第4个元素
		System.out.println("vector.subList(1, 3) ---> " + vector.subList(1, 3));

		// 通过Enumeration遍历Vector
		Enumeration<Object> enumeration = vector.elements();
		while (enumeration.hasMoreElements()) {
			System.out.print(enumeration.nextElement() + "--");
		}

		Vector<Object> retainVec = new Vector<>();
		retainVec.add(500);
		retainVec.add("Good morning");

		// 从vector中包含在retainVec中的元素的集合
		System.out.println();
		System.out.println("vector.retainAll(retainVec) ---> " + vector.retainAll(retainVec));
		System.out.println("vector --- > " + vector);

		// 获取vector对应的String数组
		Object[] arr = (Object[]) vector.toArray(new Object[0]);
		for (Object string : arr) {
			System.out.println(string);
		}
		
		// 清空Vector.clear()和removeAllElements()一样！
		vector.clear();
		vector.removeAllElements();
		
		// 判断vec 是否为空
		System.out.println("vector.isEmpty() ---> " + vector.isEmpty());
	}
}
