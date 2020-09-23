package com.kenson.thread05.producercustomer;

/**
 * @description: 测试生产和消费电影资源
 * @author: Kenson
 * @date: 2020/9/22
 */
public class MovieApp {
    public static void main(String[] args) {
        // 电影资源
        Movie movie = new Movie();
        //真实角色 生产者线程
        ProducerThread producer = new ProducerThread(movie);
        //真实角色 消费者线程
        CustomerThread customer = new CustomerThread(movie);
        // 代理角色
        Thread producerThread = new Thread(producer);
        Thread customerThread = new Thread(customer);
        //启动线程
        producerThread.start();
        customerThread.start();
    }
}
