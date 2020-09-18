package com.kenson.other.guava;

import java.util.Set;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

/**
 * 集合的操作： 交集， 差集，并集
 * @author wuchun
 * Sets.intersection()
 * Sets.difference()
 * Sets.union()
 *
 */
public class TestCollectionOper {
	public static void main(String[] args) {
		Set<Integer> sets = Sets.newHashSet(1,2,3,4,5,6);
		Set<Integer> sets2 = Sets.newHashSet(3,4,5,6,7,8,9);
		//交集
		SetView<Integer> intersection = Sets.intersection(sets, sets2);
		for (Integer integer : intersection) {
			System.out.println(integer);
		}
		System.out.println("--------------------------------");
		//差集
		SetView<Integer> diff = Sets.difference(sets, sets2);
		for (Integer integer : diff) {
			System.out.println(integer);
		}
		
		System.out.println("--------------------------------");
		//并集
		SetView<Integer> union = Sets.union(sets, sets2);
		for (Integer integer : union) {
			System.out.println(integer);
		}
	}

}
