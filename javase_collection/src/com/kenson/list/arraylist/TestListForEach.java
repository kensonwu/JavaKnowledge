package com.kenson.list.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 比较JDK8之前与JDK8之后List遍历方式的比较
 * @author: Kenson
 * @date: 2020/9/14
 */
public class TestListForEach {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");
        System.out.println("JDK8之前的遍历方式为：");
        for (String item : items) {
            System.out.println(item);
        }
        System.out.println("-----------------");
        System.out.println("Jdk8之后List的遍历方式为：");
        items.forEach(item -> {
            if ("C".equals(item)) {
                System.out.println(item);
            }
        });
    }
}
