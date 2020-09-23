package com.kenson.thread07.threadgroup;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/23
 */
public class MyThread implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ "的 i值 = " + i);
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ThreadGroup group = new ThreadGroup("我的线程组");
        Thread t1 = new Thread(group, myThread);
        Thread t2 = new Thread(myThread);
        System.out.println(t1); // Thread[Thread-0,5,我的线程组]
        System.out.println(t2); // Thread[Thread-1,5,main]
        t1.start();
    }
}
