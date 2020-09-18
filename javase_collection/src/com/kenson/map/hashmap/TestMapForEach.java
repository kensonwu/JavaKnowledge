package com.kenson.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 测试JDK8中forEach + Lambda表达式 的使用
 * @author: Kenson
 * @date: 2020/9/14
 */
public class TestMapForEach {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        // JDK8之前遍历方式
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item: " + entry.getKey() + " Count: " + entry.getValue());
        }
        System.out.println("-------------------------------");
        // JDK8之后遍历方式
        items.forEach((k, v) -> System.out.println("Item: " + k + " Count: " + v));
    }
}
