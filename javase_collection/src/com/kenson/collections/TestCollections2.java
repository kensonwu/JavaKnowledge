package com.kenson.collections;

import com.kenson.bean.ClassMate;

import java.util.*;

/**
 * 使用Collections对容器的比较
 * 实体类的比较适用于Comparable
 * 业务类适用于Comparator
 * @author wuchun
 *
 */
public class TestCollections2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Collections.addAll(list, "JavaSE", "JavaEE", "Python", "C++","Go","CSS");
        System.out.println("排序之前： " + list);
        // 开始集合元素进行排序
        Collections.sort(list);
        System.out.println("排序之后： " + list);
        // 使用二分法搜索的前提是需要先对集合进行排序的
        System.out.println("二分法搜索： " + Collections.binarySearch(list, "C++"));
        // 如果未找到返回的是插入点位置-1， 插入点就是插入要查找的元素集合仍然保持有序
        System.out.println("二分法搜索： " + Collections.binarySearch(list, "Html"));
        System.out.println("二分法搜索： " + Collections.binarySearch(list, "JavaEE"));

        List<ClassMate> mates = new ArrayList<ClassMate>();
        ClassMate m1 = new ClassMate("小花", 33);
        ClassMate m2 = new ClassMate("杨柳雨", 23);
        ClassMate m3 = new ClassMate("嬴政", 45);
        ClassMate m4 = new ClassMate("范进", 55);
        ClassMate m5 = new ClassMate("老高", 89);
        mates.add(m1);
        mates.add(m2);
        mates.add(m3);
        mates.add(m4);
        mates.add(m5);
        System.out.println("二分法搜索： " + Collections.binarySearch(mates, new ClassMate("小花", 44)));

        // 集合的拷贝
        LinkedList<String> linkedLists = new LinkedList<>();
        Collections.addAll(linkedLists, "abc","def","abc","abc","abc","abc","abc","abc");
        Collections.copy(linkedLists, list);// 如果目标集合的长度不够会报错：IndexOutOfBoundsException
        System.out.println("Copy之后, LinkedList的元素为:" + linkedLists);

        // 集合填充fill
        Collections.fill(linkedLists, null);
        System.out.println("填充后, LinkedList的 元素为：" + linkedLists);

        // 求集合的最大值和最小值
        System.out.println("list排序后元素顺序为： " + list);
        System.out.println("list的最大值：" + Collections.max(list));
        System.out.println("list的最小值：" + Collections.min(list));
        Collections.reverse(list);
        System.out.println("翻转list后： " + list);
    }
}
