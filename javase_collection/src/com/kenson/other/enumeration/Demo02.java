package com.kenson.other.enumeration;

import java.util.StringTokenizer;

/**
 * Enumeration 子类 StringTokenlizer 类似 String 中split() 方法， 字符串分割 缺点： 不支持正则表达式
 * 
 * @author wuchun
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String emailSore = "kenson@16.com;kenson@163.com;wc@google.com";
		StringTokenizer token = new StringTokenizer(emailSore, "@");
		while (token.hasMoreElements()) {
			System.out.println(token.nextElement());
		}
	}
}