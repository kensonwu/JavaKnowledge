package com.kenson.thread01.createthread.extendsthread;

/**
 * @description: 继承Thread类 模型乌龟赛跑
 * @author: Kenson
 * @date: 2020/9/20
 */
public class Tortoise extends Thread {
    @Override
    public void run() {
        // 线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("乌龟跑了" + i + "步！");
        }
    }
}
