package com.kenson.other.guava;
import java.util.ArrayList;
/**
 * 只读设置
 */
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

public class TestGuavaReadOnly {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");

		//对原有的list进行包装，相当于原有list的一个试图/快照，不够安全
		List<String> readList = Collections.unmodifiableList(list);
//		 readList.add("d");
		list.add("d");	//改变原有List， 视图也一起改变
		
		//对比查看guava实现, Guava对只读设置，安全可靠，并且相对简单
		List<String> immutableList = ImmutableList.of("a", "b", "c");
		immutableList.add("ccc");	//java.lang.UnsupportedOperationException
	}
}
