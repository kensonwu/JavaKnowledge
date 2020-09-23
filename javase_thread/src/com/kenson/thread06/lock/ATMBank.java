package com.kenson.thread06.lock;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 使用显示锁解决数据错乱的问题
 * 注意事项：
 * 1. 使用了Lock之后就不能使用notify()/notifyAll(), wait()这个三个方法了，因为这个三个方法只能用在同步代码块儿或者同步方法中
 * 2. 使用Lock之后如何实现线程间的通信？
 * await(), singal() singalAll()
 * @author: Kenson
 * @date: 2020/9/23
 */
public class ATMBank implements Runnable {
    private Account account;
    // 显示锁
    private Lock lock = new ReentrantLock();

    public ATMBank() {
    }

    public ATMBank(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        int drawNum = 200;
        for (int i = 0; i < 10; i++) {
            lock.lock();
            if (account.getBlance() >= drawNum) {
                account.setBlance(account.getBlance() - drawNum);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "--取款成功，取款金额为： " + drawNum + "余额为：" + account.getBlance());
            } else {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "--取款失败，余额不足，余额为：" + account.getBlance());
                lock.unlock();
            }
        }
    }
}
