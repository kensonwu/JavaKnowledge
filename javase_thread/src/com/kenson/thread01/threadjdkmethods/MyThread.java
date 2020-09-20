package com.kenson.thread01.threadjdkmethods;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class MyThread implements Runnable {
    // 全局变量
    private int num = 0;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
//        while (num < 10) {
            System.out.println(Thread.currentThread().getName() + " ---> " + num++);
        }
    }

    public void stop() {
        this.flag = !this.flag;
    }
}
