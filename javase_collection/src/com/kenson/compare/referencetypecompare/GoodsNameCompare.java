package com.kenson.compare.referencetypecompare;

import java.util.Comparator;

/**
 * 按照商品名称排序 （降序）
 * @author wuchun
 *
 */
public class GoodsNameCompare implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
