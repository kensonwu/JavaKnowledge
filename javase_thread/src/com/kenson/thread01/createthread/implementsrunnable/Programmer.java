package com.kenson.thread01.createthread.implementsrunnable;

/**
 * @description: 实现Runnable接口 创建线程
 * 1. 推荐使用此方式创建线程
 * 2. 避免单继承的局限性
 * 3. 便于共享资源
 * @author: Kenson
 * @date: 2020/9/20
 */
public class Programmer implements Runnable{
    @Override
    public void run() {
        //线程体
        for (int i = 0; i < 100; i++) {
            System.out.println("一边写代码，一边听歌" + i);
        }
    }
}
