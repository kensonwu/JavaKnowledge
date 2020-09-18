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
public class TestCollectionOper {
	public static void main(String[] args) {
		Set<Integer> sets = Sets.newHashSet(1,2,3,4,5,6);
		Set<Integer> sets2 = Sets.newHashSet(3,4,5,6,7,8,9);
		
		//并集
		System.out.println("===============并集===============");
		Collection<Integer> col = CollectionUtils.union(sets, sets2);
		for (Integer integer : col) {
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("===============交集===============");
		//交集
		col = CollectionUtils.intersection(sets, sets2);
		for (Integer integer : col) {
			System.out.print(integer + ",");
		}
		
		System.out.println();
		System.out.println("===============差集===============");
		//差集 sets 集合相对于sets2的补集就是 1,2
		col = CollectionUtils.subtract(sets, sets2);
		for (Integer integer : col) {
			System.out.print(integer + ",");
		}
	}
}
