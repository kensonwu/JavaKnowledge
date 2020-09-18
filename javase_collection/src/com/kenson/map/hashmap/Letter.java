package com.kenson.map.hashmap;

/**
 * JavaBean 存储数据， 也叫BO，PO,VO
 * 
 * @author wuchun
 *
 */
public class Letter {
	private String name;
	private int count;

	public Letter() {

	}

	public Letter(String name) {
		this.name = name;
	}

	// alt+shift+s -->o
	public Letter(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	// Setter and Getter方法 快速生成
	// alt+shift+s -->r-->tab--->enter-->shift+tab-->enter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
