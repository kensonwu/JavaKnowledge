package com.kenson.thread01.staticproxy;

/**
 * @description: 真实角色
 * @author: Kenson
 * @date: 2020/9/20
 */
public class You implements  Marry {
    @Override
    public void marry() {
        System.out.println("您和张曼玉结婚了......");
    }
}
