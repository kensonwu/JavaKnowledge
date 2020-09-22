package com.kenson.thread04.sync.synchronize;

import java.util.Date;

/**
 * @description: 购买火车票线程类
 * @author: Kenson
 * @date: 2020/9/20
 */
public class BuyTicket implements Runnable {
    // 总共的票数
    private int tktNum = 10;
    // 控制线程执行的标识
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            // 购票
//            grabbingTickets1(); // 线程不安全,导致有负数票的情况出现
//            grabbingTickets2(); // 线程不安全,导致有负数票的情况出现
            grabbingTickets3(); // 线程安全
//            grabbingTickets4(); // 线程不安全,导致有重复数票的情况出现
//            grabbingTickets5(); // 线程不安全,导致有重复数票的情况出现
//            grabbingTickets6(); // 线程不安全 导致有负数票的情况出现
        }
    }

    /**
     * 线程不安全
     */
    public void grabbingTickets6() {
        if (tktNum <= 0) {
            flag = false; // 跳出循环
            return;
        }
        synchronized (this) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了票为： " + tktNum-- + "的票！");
        }
    }

    /**
     * 线程不安全， 错定资源错误
     */
    public void grabbingTickets5() {
        synchronized ((Integer) tktNum) { // 锁定票号
            if (tktNum <= 0) {
                flag = false; // 跳出循环
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了票为： " + tktNum-- + "的票！");
        }
    }

    /**
     * 锁定范围错误
     */
    public void grabbingTickets4() {
        synchronized (this) {
            if (tktNum <= 0) {
                flag = false; // 跳出循环
                return;
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 抢到了票为： " + tktNum-- + "的票！");

    }

    /**
     * 同步方法块
     * 可以实现锁定资源
     */
    public void grabbingTickets3() {
//        synchronized (this) {
        synchronized (BuyTicket.class) {
            if (tktNum <= 0) {
                flag = false; // 跳出循环
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 抢到了票为： " + tktNum-- + "的票！");
        }
    }

    /**
     * 锁定整个方法
     * 锁定不正确还是会出现负数的票
     */
    public synchronized void grabbingTickets2() {
        if (tktNum <= 0) {
            flag = false;
        }
        try {
            // 线程等待0.5秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 抢到了票为： " + tktNum-- + "的票！");
    }

    /**
     * 抢票
     * 线程不安全
     * 此时可能出现 负数的票号
     */
    public void grabbingTickets1() {
        if (tktNum <= 0) {
            flag = false;
        }
        try {
            // 线程等待0.5秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 抢到了票为： " + tktNum-- + "的票！");
    }
}
