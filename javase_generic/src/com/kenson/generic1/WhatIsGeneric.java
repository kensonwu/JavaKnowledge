package com.kenson.generic1;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 什么泛型
 * 泛型入门， 泛型使用 <>表示
 * 1.泛型： 标签、泛化类型
 * 2.作用： 省心，安全
 * @author: Kenson
 * @date: 2020/9/15
 */
public class WhatIsGeneric {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 安全， 此时只能添加String类型的值
        // list.add(1);
        list.add("so easy");
        // 省心
        String str = list.get(0);
        System.out.println(str);
    }
}
