package com.kenson.other.syncread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用Collections管理同步容器
 * 	synchronizedSet(Set<T> s)
	synchronizedList(List<T> list)
	synchronizedMap(Map<K,V> m)
 * @author wuchun
 *
 */

public class TestSyncCollections {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		//list可以同步
		List<String> syncList = Collections.synchronizedList(list);
		System.out.println("线程安全List制作完成");
	}
}
