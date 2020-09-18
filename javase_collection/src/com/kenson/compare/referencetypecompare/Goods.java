package com.kenson.compare.referencetypecompare;

/**
 * 商品实体类
 * 不实现任何的接口， 也就是一个很干净的实体类
 * @author wuchun
 *
 */
public class Goods {
	//商品名称
	private String name;

	//价格
	private double price;
	
	//收藏量
	private int fav;
	
	public Goods(){
		
	}

	public Goods(String name, double price, int fav) {
		super();
		this.name = name;
		this.price = price;
		this.fav = fav;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getFav() {
		return fav;
	}

	public void setFav(int fav) {
		this.fav = fav;
	}
	
	@Override
	public String toString() {
		return "商品名称：" + name + ",收藏量：" + this.fav + ",价格：" + this.price + "\n";
	}
}
