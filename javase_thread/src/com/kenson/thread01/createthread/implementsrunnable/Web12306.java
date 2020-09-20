package com.kenson.thread01.createthread.implementsrunnable;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class Web12306 implements  Runnable {
    private int ticketNum = 50;
    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + ticketNum--);//抢到票就要减1
        }
    }
}
