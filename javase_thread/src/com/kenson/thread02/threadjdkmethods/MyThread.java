package com.kenson.thread02.threadjdkmethods;

import javax.swing.plaf.TableHeaderUI;

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
//            try {
//                Thread.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(Thread.currentThread().getName() + " ---> " + num++);
        }
    }

    public void stop() {
        this.flag = !this.flag;
    }
}
