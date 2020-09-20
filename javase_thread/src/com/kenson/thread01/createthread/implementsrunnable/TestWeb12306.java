package com.kenson.thread01.createthread.implementsrunnable;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestWeb12306 {
    public static void main(String[] args) {
        //真实角色
        Web12306 wb = new Web12306();
        // 代理角色 Thread
        Thread thread1 = new Thread(wb, "农民工"); // 为线程取名
        Thread thread2 = new Thread(wb, "金融大佬");
        Thread thread3 = new Thread(wb, "IT攻城狮");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
