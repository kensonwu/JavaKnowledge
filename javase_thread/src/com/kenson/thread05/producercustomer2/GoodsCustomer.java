package com.kenson.thread05.producercustomer2;

import com.kenson.thread05.producercustomer2.Goods;

/**
 * @description: 消费者线程
 * @author: Kenson
 * @date: 2020/9/23
 */
public class GoodsCustomer implements Runnable {
    // 商品
    private Goods good;

    public GoodsCustomer() {
    }

    public GoodsCustomer(Goods good) {
        this.good = good;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (good) {
                if (!good.isFlag()) {// 如果没有商品，消费者需要等待
                    try {
                        good.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 消费商品
                try {
                    Thread.sleep(1000); // 用于测试， 主要能更看到问题
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "取走了： " + good.getBrand() + "牌的" + good.getName());
                // 当消费完商品之后需要将good的flag设置为false
                good.setFlag(false);
                //通知生产者生产
                good.notify();
            }
        }
    }
}
