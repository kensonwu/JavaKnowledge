package com.kenson.map.treemap;

/**
 * Person实体类
 * @author wuchun
 *
 */
public class Person {
	//名字
	private final String name;
	
	//帅气指数
	private final int handsome;

	public Person(){
		name = null;
		handsome = 0;
	}
	
	public Person(String name, int handsome) {
		super();
		this.name = name;
		this.handsome = handsome;
	}
	
	public String getName() {
		return name;
	}

	/*public void setName(String name) {
		this.name = name;
	}*/

	public int getHandsome() {
		return handsome;
	}

	/*public void setHandsome(int handsome) {
		this.handsome = handsome;
	}*/
	
	@Override
	public String toString() {
		return "名字：" + name + ",帅气指数： " + this.handsome + "\n";
	}
	
	
}
