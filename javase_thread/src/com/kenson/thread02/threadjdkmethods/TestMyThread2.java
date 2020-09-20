package com.kenson.thread02.threadjdkmethods;

/**
 * @description: 测试线程的优先级
 * 优先级： 概率，不是绝对的优先级
 * MAX_PRIORITY	10
 * NORM_PRIORITY	5(默认)
 * MIN_PRIORITY	1
 * setPriority()
 * getPriority()
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestMyThread2 {
    public static void main(String[] args) throws InterruptedException {
        // 真实角色
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // 代理角色
        Thread proxy1 = new Thread(myThread1);
        Thread proxy2 = new Thread(myThread1);
        // 获取线程名称
        System.out.println("线程的默认优先级：" + proxy1.getPriority()); // 默认优先级有5
        System.out.println("线程的默认优先级：" + proxy2.getPriority()); // 默认优先级有5

        proxy1.setPriority(Thread.MIN_PRIORITY);
        proxy2.setPriority(Thread.MAX_PRIORITY);

        proxy1.start();
        proxy2.start();

        // 主方法线程等待200毫秒
        Thread.sleep(200);
        myThread1.stop();
        myThread2.stop();
    }
}
