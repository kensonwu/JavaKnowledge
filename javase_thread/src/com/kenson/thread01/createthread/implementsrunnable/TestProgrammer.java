package com.kenson.thread01.createthread.implementsrunnable;

/**
 * @description: 测试通过实现Runnable接口的方式的线程
 * 调用时 使用的静态代理模式
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestProgrammer {
    public static void main(String[] args) {
        // 创建真实角色
        Programmer programmer = new Programmer();
        // 创建代理角色 + 真实角色引用， Thread就是代理角色 持有真实角色的引用
        Thread thread = new Thread(programmer);
        // 调用Thread的start()方法启动线程体
        thread.start();
        // main方法线程体执行的代码
        for (int i = 0; i < 100; i++) {
            System.out.println("TestProgrammer类...." + i);
        }
    }
}
