package com.kenson.other.commons;

import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;

import com.google.common.collect.Sets;

/**
 * 集合的操作： 
 * 1. 交集	CollectionUtils.intersection() 或者retainAll()
 * 2. 差集	CollectionUtils.subtract();	
 * 3. 并集	CollectionUtils.union();
 * @author wuchun
 *
 */
public class TestCollectionOper2 {
	public static void main(String[] args) {
		Set<Integer> sets = Sets.newHashSet(1,2,3);
		Set<Integer> sets2 = Sets.newHashSet(3,4,5,6,7,8,9);
		Collection<Integer> col = CollectionUtils.subtract(sets, sets2);
		System.out.println("===============补集===============");
		//补集
		for (Integer integer : col) {
			System.out.print(integer + ",");
		}
	}
}
