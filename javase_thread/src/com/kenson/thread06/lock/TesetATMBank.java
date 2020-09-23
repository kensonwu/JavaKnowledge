package com.kenson.thread06.lock;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/23
 */
public class TesetATMBank {
    public static void main(String[] args) {
        Account account = new Account(500, "张三的信用卡");
        ATMBank atmBank = new ATMBank(account);
        Thread thread1 = new Thread(atmBank, "张三本人");
        Thread thread2 = new Thread(atmBank, "张三儿子");
        thread1.start();
        thread2.start();
    }
}
