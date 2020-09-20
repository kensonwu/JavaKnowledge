package com.kenson.thread01.threadjdkmethods;

/**
 * @description: 测试自定义线程类
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestMyThread1 {
    public static void main(String[] args) throws InterruptedException {
        // 真实角色
        MyThread myThread1 = new MyThread();
        // 代理角色
        Thread proxy = new Thread(myThread1);

        // 获取线程名称
        System.out.println("线程：" + proxy); // [线程名, 优先级, 线程组名] 默认优先级有5
        System.out.println("线程的默认名称：" + proxy.getName()); // 默认名称 Thread-0

        // 设置线程名称
        proxy.setName("TestMyThread");
        System.out.println("线程的名称: " + proxy.getName());

        // 启动之前线程的状态
        System.out.println("启动之前线程的状态： " + proxy.getState()); // NEW
        System.out.println("启动之前线程是否激活: " + proxy.isAlive()); // false

        // 启动线程
        proxy.start();

        // 启动之后线程的状态
        System.out.println("启动之后线程的状态： " + proxy.getState()); // RUNNABLE
        System.out.println("启动之后线程是否激活: " + proxy.isAlive()); // true

        // 主程序休眠2毫秒
        Thread.sleep(10);
        // sleep之后的状态
        System.out.println("sleep之后线程的状态： " + proxy.getState()); // TERMINATED
        System.out.println("sleep之后线程是否激活: " + proxy.isAlive()); // false

        // 停止线程
        myThread1.stop();
        System.out.println("停止后线程的状态： " + proxy.getState()); // TERMINATED
        System.out.println("停止后线程是否激活：" + proxy.isAlive()); // false

    }
}
