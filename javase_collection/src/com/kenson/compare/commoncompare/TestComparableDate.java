package com.kenson.compare.commoncompare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author wuchun
 *
 */
public class TestComparableDate {
	public static void main(String[] args) {
		Date[] arr = new Date[3];
		arr[0] = new Date();
		arr[1] = new Date(System.currentTimeMillis()-1000*60*60);
		arr[2] = new Date(System.currentTimeMillis()+1000*60*60);
		ArraySortUtil.sort(arr,"DESC");	//降序序排列
		System.out.println(Arrays.toString(arr));
		
		//如果是字符串
		String[] arr2 = {"a","abcd","abc", "def"};
		ArraySortUtil.sort(arr2,"DESC");	//降序排列
		System.out.println(Arrays.toString(arr2));
		
		//将字符串存入到List容器中
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("a");
		list.add("xyz");
		ArraySortUtil.sort(list);
		System.out.println(list.toString());
		
		System.out.println("======使用Comparator 排序数组===========");
		String[] arr3 = {"a","abcd","abc", "def"};
		ArraySortUtil.sort(arr3, new StringCompare());
		System.out.println(Arrays.toString(arr3));
		
		System.out.println("======List 排序 使用Comparator 排序===========");
		list = new ArrayList<String>();
		list.add("abc");
		list.add("def");
		list.add("a");
		list.add("xyz");
		ArraySortUtil.sort(list,new StringCompare());
		System.out.println(list.toString());
	}
}
