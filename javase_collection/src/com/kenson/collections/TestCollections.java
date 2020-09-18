package com.kenson.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections对容器的比较
 * 实体类的比较适用于Comparable
 * 业务类适用于Comparator
 * @author wuchun
 *
 */
public class TestCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("a");
		list.add("xyz");
		Collections.sort(list, new StringCompare());
		System.out.println(list.toString());
	}
}
