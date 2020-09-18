package com.kenson.compare.referencetypecompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author wuchun
 *
 */
public class GoodsApp {
	public static void main(String[] args) {
		List<Goods> goods = new ArrayList<Goods>();
		goods.add(new Goods("苹果", 100, 20000));
		goods.add(new Goods("猕猴桃", 5000, 1000));
		goods.add(new Goods("香蕉", 400, 500));
		goods.add(new Goods("草莓", 10, 300));
		System.out.println("排序前： " + goods);
		//Collections.sort(goods, new GoodsPriceCompare());
		//Collections.sort(goods, new GoodsFavCompare());
		Collections.sort(goods, new GoodsNameCompare());
		//降序
		System.out.println("排序后： " + goods);
	}
}
