package com.kenson.compare.referencetypecompare;

import java.util.Comparator;

/**
 * 实现商品价格的排序， 没有其他任何依赖的排序 按照价格排序的业务类（按降序）
 * 
 * @author wuchun
 *
 */

public class GoodsPriceCompare implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		// 降序 就是用负数，前面加一个负号
		return -(o1.getPrice() - o2.getPrice() > 0 ? 1 : o1.getPrice() == o2.getPrice() ? 0 : -1);
	}

}
