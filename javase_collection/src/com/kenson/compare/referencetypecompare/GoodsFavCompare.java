package com.kenson.compare.referencetypecompare;

import java.util.Comparator;

/**
 * 按照收藏量升序排序
 * @author wuchun
 *
 */
public class GoodsFavCompare implements Comparator<Goods> {

	@Override
	public int compare(Goods o1, Goods o2) {
		return o1.getFav()-o2.getFav();
	}

}
