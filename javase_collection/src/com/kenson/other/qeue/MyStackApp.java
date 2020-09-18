package com.kenson.other.qeue;

public class MyStackApp {
	
	public static void main(String[] args) {
		MyStack<String> myStack = new MyStack<>(3);
		myStack.push("www.baidu.com");
		myStack.push("www.google.com");
		myStack.push("www.sina.com");
		myStack.push("www.kenson.com");
		System.out.println("大小：" + myStack.size());
		
		//遍历
		String item = null;
		while (null != (item = myStack.pop())) {
			// LIFO, 后进先出
			System.out.println(item);
		}
	}
	
	
	
	
	

}
