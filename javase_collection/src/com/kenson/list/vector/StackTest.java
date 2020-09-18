/**  
 * Project Name:collection  
 * File Name:StackTest.java  
 * Package Name:com.kenson.collection.vectortest  
 * Date:May 22, 201810:33:25 AM  
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.  
 *  
*/  
  
package com.kenson.list.vector;

import java.util.Iterator;
import java.util.Stack;

/**  
 * ClassName:StackTest   
 * Function: 测试Stack的常用API .    
 * Date:     May 22, 2018 10:33:25 AM   
 * @author   CHUNWU  
 * @version  0.1  
 * @since    JDK 1.8  
 * @see
 * @link     www.imkenson.com        
 */
public class StackTest {
	
	public static void main(String[] args) {
		// 新建一个Stack
		Stack<Object> stack = new Stack<>();
		
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		// 查找 2 在栈中的位置， 并输出
		System.out.println("The stack is : " + stack);	// [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		int positon = stack.search(2);
		System.out.println("The position of 2 is :   " + positon); // 8
		
		// pop栈顶元素 并遍历
		stack.pop();
		System.out.println("The stack is : " + stack);	// [0, 1, 2, 3, 4, 5, 6, 7, 8] 会删除栈顶元素
		
		// peek栈顶元素 后遍历
		stack.peek();
		System.out.println("The stack is : " + stack);	// [0, 1, 2, 3, 4, 5, 6, 7, 8] 不会删除
		
		// 通过快速访问遍历 stack
		iteratorThroughRandomAccess(stack);
		System.out.println();
		// 通过Iterator遍历stack
		iteratorThroughIterator(stack);
		
		
		
	}

	private static void iteratorThroughIterator(Stack<Object> stack) {
		if (stack == null)
			return;
		System.out.print("each element is:  ");
		Iterator<Object> iterator = stack.iterator();
		System.out.print("iterator each element of stack :  ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
	}

	private static void iteratorThroughRandomAccess(Stack<Object> stack) {
		if (stack == null)
			return;
		
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.get(i) + " ");
		}
	}

}
  
