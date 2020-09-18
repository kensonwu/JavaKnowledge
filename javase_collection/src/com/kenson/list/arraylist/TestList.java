package com.kenson.list.arraylist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList();
        /**
         * 1. ArrayList底层实现是数组， 线程不安全，效率高。 查询速度快， 增删改速度慢。
         * 2. LinkedList底层实现是链表， 线程不安全，效率高. 查询速度慢， 增删改速度快。
         * 3. Vector 底层实现是链表，线程安全，效率低。查询速度慢， 增删改速度快。
         */
        list.add("aaa");
        list.add(new Date());
        list.add(new Dog());
        list.add(1234); // 包装类的自动装箱
        System.out.println(list.size());

        System.out.println(list.isEmpty());
//		list.remove(new Date());		//hashcode 和equals方法是有联系的
//		System.out.println(list.size());

        List list2 = new ArrayList();
        list2.add("ccc");
        list2.add("ddd");
        list.add(list2);
        System.out.println(list.size());

        //跟顺序的操作
        String string = (String) list.get(0);
        System.out.println(string);

        System.out.println("###########################");
        List list3 = new ArrayList();
        list3.add("list3");
        //在set某个index位置的时候， 必须是在那个index位置已经设置了内容才可以set值， 某种会报java.lang.IndexOutOfBoundsException的错
        list3.set(0, "first element in list3");
        System.out.println(list3);
    }
}

class Dog {
}
