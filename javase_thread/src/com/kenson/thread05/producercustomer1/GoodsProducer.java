package com.kenson.thread05.producercustomer1;

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
            }
        }
    }
}
