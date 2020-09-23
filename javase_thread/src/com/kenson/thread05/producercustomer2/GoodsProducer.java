package com.kenson.thread05.producercustomer2;

/**
 * @description: 生产者线程
 * @author: Kenson
 * @date: 2020/9/23
 */
public class GoodsProducer implements Runnable {
    // 商品
    private Goods good;

    public GoodsProducer() {
    }

    public GoodsProducer(Goods good) {
        this.good = good;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (good) {
                if (good.isFlag()) { // 如果有商品则需要等待
                    try {
                        good.wait(); // 在good对象上等待， 释放锁， 进入good对象的等待池
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 被唤醒之后，将从wait()之后的代码开始执行
                // 生产商品
                if (i % 2 == 0) {
                    good.setBrand("娃哈哈");
                    try {
                        Thread.sleep(1000); // 用于测试， 主要能更看到问题
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    good.setName("矿泉水");
                } else {
                    good.setBrand("旺仔");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    good.setName("小馒头");
                }
                System.out.println(Thread.currentThread().getName() + "生产了：" + good.getBrand() + "牌的" + good.getName());

                // 生产完成之后就有商品了，有商品flag就需要设置为true
                good.setFlag(true);
                
                // 通知消费者取商品
                good.notify();
            }
        }
    }
}
