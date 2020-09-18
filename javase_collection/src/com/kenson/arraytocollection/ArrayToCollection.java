package com.kenson.arraytocollection;

import java.util.*;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/15
 */
public class ArrayToCollection {
    public static void main(String[] args) {
        //数组转集合
        int[] arr = {11, 22, 33};
        List<int[]> list1 = Arrays.asList(arr);
        System.out.println("list1： " + list1.size()); // 注意这里的个数是1个
        Integer[] arr2 = {11, 22, 33};
        List<Integer> list2 = Arrays.asList(arr2);
        System.out.println("list2的元素个数为： " + list2.size());
        // list2.add(1); // 使用Arrays.asList(arr)这种方式得到的List是不可变的
        System.out.println(list2);

        //集合转数组
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "Google", "Oracle", "Sun", "IBM", "Microsoft", "JD");
        Object[] setArr = set.toArray();
        for (Object o : setArr) {
            System.out.print(o + "\t");
        }
        String [] arr1 = {};
        System.out.println();
        String[] arr3 = set.toArray(arr1);

    }
}
