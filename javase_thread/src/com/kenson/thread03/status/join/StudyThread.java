package com.kenson.thread03.status.join;

/**
 * @description: 如何使线程终止
 * 1.线程类中定义线程体使用标识
 * 2.线程体使用该标识
 * 3.对外提供方法改变标识
 * @author: Kenson
 * @date: 2020/9/20
 */
public class StudyThread implements Runnable {
    // 1.线程类中定义线程体使用标识
    private boolean flag = true;

    @Override
    public void run() {
        // 2. 线程体使用该标识
        while (flag) {
            System.out.println("Studying thread....");
        }
    }

    // 对外提供方法改变标识
    public void stop() {
        this.flag = false;
    }
}
