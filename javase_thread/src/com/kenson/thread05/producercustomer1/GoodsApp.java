package com.kenson.thread05.producercustomer1;

/**
 * @description: 测试类
 * @author: Kenson
 * @date: 2020/9/23
 */
public class GoodsApp {
    public static void main(String[] args) {
        Goods goods = new Goods();
        GoodsProducer producer = new GoodsProducer(goods);
        GoodsCustomer customer = new GoodsCustomer(goods);
        Thread thread1 = new Thread(producer, "生产者");
        Thread thread2 = new Thread(customer, "消费者");
        thread1.start();
        thread2.start();
    }
}
