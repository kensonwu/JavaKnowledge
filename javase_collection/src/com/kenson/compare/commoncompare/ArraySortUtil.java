package com.kenson.compare.commoncompare;

import java.util.Comparator;
import java.util.List;

public class ArraySortUtil {
	/**
	 * 数组排序，使用泛型方法
	 */
	public static <T extends Comparable<T>> void sort(T[] arr, String string) {
		// 从小到大
		boolean sorted = true;
		int length = arr.length;
		for (int j = 0; j < arr.length - 1; j++) {
			sorted = true; // 假定有序
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (((Comparable) arr[i]).compareTo(arr[i + 1]) > 0 || string == "ASC") {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false; // 交换了就没顺序了 设为false
				}else if (((Comparable) arr[i]).compareTo(arr[i + 1]) < 0 || string == "DESC") {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false; // 交换了就没顺序了 设为false
				}
			}
			if (sorted) { // 减少趟数
				break;
			}
		}
	}
	
	/**
	 * use object to bubble sort the array data
	 * 
	 * @param arr
	 */
	public static void sort(Object[] arr) {
		boolean sorted = true;
		int length = arr.length;
		for (int j = 0; j < length - 1; j++) {
			sorted = true; // 假定有序
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (((Comparable) arr[i]).compareTo(arr[i + 1]) > 0) {
					Object temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false; // 交换了就没顺序了 设为false
				}
			}
			if (sorted) { // 减少趟数
				break;
			}
		}
	}
	

	/**
	 * use object to bubble sort the array data, ASC
	 * 
	 * @param arr
	 */
	public static void sort(Object[] arr, Comparator cmp) {
		boolean sorted = true;
		int length = arr.length;
		for (int j = 0; j < arr.length - 1; j++) {
			sorted = true; // 假定有序
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (cmp.compare(arr[i], arr[i+1])>0) {
					Object temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false; // 交换了就没顺序了 设为false
				}
			}
			if (sorted) { // 减少趟数
				break;
			}
		}
	}
	
	/**
	 * 容器排序（使用泛型方法）
	 */
	public static <T extends Comparable<T>> void sort(List<T> list) {
		//第一步将List转成数组
		Object[] arr = list.toArray();
		sort(arr);
		//第二步：改变容器中对应的值
		for (int i = 0; i < arr.length; i++) {
			list.set(i, (T) arr[i]);
		}
	}
	
	public static <T> void sort(List<T> list, Comparator<T> cmp) {
		//第一步将List转成数组
		Object[] arr = list.toArray();
		sort(arr,cmp);
		//第二步：改变容器中对应的值
		for (int i = 0; i < arr.length; i++) {
			list.set(i, (T) arr[i]);
		}
	}

}
