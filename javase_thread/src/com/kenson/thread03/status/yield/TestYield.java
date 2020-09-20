package com.kenson.thread03.status.yield;

/**
 * @description: yield:暂停线程
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestYield extends Thread {
    public static void main(String[] args) {
        TestYield yield = new TestYield();
        Thread thread = new Thread(yield);
        // 启动线程
        thread.start();
        for (int i = 0; i < 1000; i++) {
            if (i % 20 == 0) {
                // 暂停main方法线程
                Thread.yield();
            }
            System.out.println("main......" + i);
        }
    }


    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Run.........." + i);
        }
    }
}
