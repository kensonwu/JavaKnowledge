/**
 * Project Name:collection
 * File Name:ListCompareTest.java
 * Package Name:com.kenson.collection.alllisttest
 * Date:May 22, 201811:01:55 AM
 * Copyright (c) 2018, wc-08-03@hotmail.com All Rights Reserved.
 */

package com.kenson.list.arraylist;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * ClassName:ListCompareTest Function: 对Java List的总结.
 * (01) List 是一个接口，它继承于Collection的接口。它代表着有序的队列。 (02) AbstractList
 * 是一个抽象类，它继承于AbstractCollection。AbstractList实现List接口中除size()、get(int
 * location)之外的函数。 (03) AbstractSequentialList
 * 是一个抽象类，它继承于AbstractList。AbstractSequentialList 实现了“链表中，根据index索引值操作链表的全部函数”。
 * (04) ArrayList, LinkedList, Vector, Stack是List的4个实现类。 ArrayList
 * 是一个数组队列，相当于动态数组。它由数组实现，随机访问效率高，随机插入、随机删除效率低。 LinkedList
 * 是一个双向链表。它也可以被当作堆栈、队列或双端队列进行操作。LinkedList随机访问效率低，但随机插入、随机删除效率高。 Vector
 * 是矢量队列，和ArrayList一样，它也是一个动态数组，由数组实现。但是ArrayList是非线程安全的，而Vector是线程安全的。 Stack
 * 是栈，它继承于Vector。它的特性是：先进后出(FILO, First In Last Out)。 当然它也是线程安全的。
 * List使用场景 (01) 对于需要快速 插入、删除元素， 我们选择使用LinkedList. (02) 对于需要快速随机访问元素，
 * 我们选择使用ArrayList. 场景： action需要返回数据给前端一个循环的列表数据 (03) 单线程环境， 我们选择 ArrayList
 * 多线程环境， 也就是list可能被多个线程操作， 我们选择 线程同步的 Vector
 * 下面类 用于 ：对比ArrayList和LinkedList的插入、随机读取效率、删除的效率
 * Date: May 22, 2018 11:01:55 AM
 *
 * @author CHUNWU
 * @version 0.1
 * @link www.imkenson.com
 * @see
 * @since JDK 1.8
 */
public class ListCompareTest {
    // 定义一个常量用于将0 到COUNT的数插入到不同类型的List中
    private final static int COUNT = 100000;

    // 首先定义4中类型的 List
    private static LinkedList<Integer> linkedList = new LinkedList<Integer>();
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private static Vector<Integer> vector = new Vector<Integer>();
    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
		// 插入数据
		insertByPosition(arrayList);
		insertByPosition(linkedList);
		insertByPosition(vector);
		insertByPosition(stack);
		System.out.println("================================================================");
		// 读取数据
		readByPosition(arrayList);
		readByPosition(linkedList);
		readByPosition(vector);
		readByPosition(stack);
		
		System.out.println("================================================================");
		// 删除数据
		deleteByPosition(arrayList);
		deleteByPosition(linkedList);
		deleteByPosition(vector);
		deleteByPosition(stack);
    }

    // 获取list的名称
    private static String getListName(List<?> list) {
        if (list instanceof LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Stack) {
            return "Stack";
        } else if (list instanceof Vector) {
            return "Vector";
        }
        return "";
    }

    // 向list的指定位置插入COUNT个元素，并统计时间
    private static void insertByPosition(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0 处插入COUNT个数
        for (int i = 0; i < COUNT; i++) {
            list.add(0, i);
        }

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;

        System.out.println(getListName(list) + " : insert " + COUNT + " elements into the 1st position use time："
                + interval + " ms");
    }

    // 从list的指定位置删除COUNT个元素，并统计时间
    private static void deleteByPosition(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0 处插入COUNT个数
        for (int i = 0; i < COUNT; i++) {
            list.remove(0);
        }

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;

        System.out.println(getListName(list) + " : delete " + COUNT + " elements into the 1st position use time："
                + interval + " ms");
    }

    // 根据position，不断从list中读取元素，并统计时间
    private static void readByPosition(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0 处插入COUNT个数
        for (int i = 0; i < COUNT; i++) {
            list.get(i);
        }

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;

        System.out.println(getListName(list) + " : read  " + COUNT + " elements into the 1st position use time："
                + interval + " ms");
    }

}
