package com.kenson.compare.commoncompare;

import java.util.Arrays;

/**
 * 
 * @author wuchun
 *
 */
public class TestComparableString {
	public static void main(String[] args) {
		String[] arr = {"a","abcd","abc", "def"};
		bubbleSortFinal(arr);
	}
	
	public static void bubbleSortFinal(String[] arr){
		boolean sorted = true;
		int length = arr.length;
		for (int j = 0; j < arr.length - 1; j++) {
			sorted = true;	//假定有序
			//System.out.println("第" + (j + 1) + "趟");
			for (int i = 0; i < arr.length - 1 - j; i++) {
				//System.out.println("第" + (i + 1) + "次");
				if (arr[i].compareTo(arr[i+1])>0) {
					String temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					sorted = false;	//交换了就没顺序了 设为false
				}
				//System.out.println(Arrays.toString(arr));
			}
			if (sorted) {	//减少趟数
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
