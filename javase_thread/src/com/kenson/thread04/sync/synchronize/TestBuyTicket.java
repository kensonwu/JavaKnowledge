package com.kenson.thread04.sync.synchronize;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        Thread t1 = new Thread(ticket, "窗口A");
        Thread t2 = new Thread(ticket, "窗口B");
        Thread t3 = new Thread(ticket, "窗口C");
        t1.start();
        t2.start();
        t3.start();
    }
}
