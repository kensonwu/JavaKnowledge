package com.kenson.genericadvance;

import com.kenson.bean.Apple;
import com.kenson.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 泛型没有多态
 * 2. 没有泛型数组
 * @author wuchun
 *
 */
public class Polymorphism {
	public static void main(String[] args) {
		//多态
		Fruit f = new Apple();
		//泛型没有多态
		//List<Fruit> list = new ArrayList<Apple>();
		
		//但是可以这样解决
		List<? extends Fruit> list = new ArrayList<Apple>();
		
		//没有泛型数组
		//Fruit<String>[] arr = new Fruit()<String>[10];
		
		//JDK1.7关于泛型的简化
		List<Fruit> list2 = new ArrayList<>(); //可以不用写Fruit
	}

}
