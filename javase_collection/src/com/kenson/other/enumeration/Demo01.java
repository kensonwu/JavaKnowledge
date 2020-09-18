package com.kenson.other.enumeration;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration的使用
 * 1. hasMoreElements()
 * 2. 获取nextElement()
 * 
 * Vector 的element() 方法
 * @author wuchun
 *
 */

public class Demo01 {
	public static void main(String[] args) {
		Vector<String> vc = new Vector<>();
		vc.add("JAVASE");
		vc.addElement("HTML");
		vc.add("Pyhon");	
		vc.add("Go+");
		
		//遍历Vector
		Enumeration<String> en = vc.elements();
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
	}

}
