package com.kenson.thread01.createthread.extendsthread;

/**
 * @description: 调用龟兔赛跑
 * 创建子类对象
 * 调用start()方法开启线程
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestRabbitTortoiseRacing {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        rabbit.start();
        tortoise.start();
    }
}
