package com.kenson.thread08.threadpool;

import org.omg.CORBA.portable.ServantObject;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description: 使用线程池执行大量Runnable命令
 * @author: Kenson
 * @date: 2020/9/23
 */
public class TestThreadPool01 {
    public static void main(String[] args) {
        // 创建一个可伸缩数量的线程池
//        ExecutorService service = Executors.newCachedThreadPool();
        // 创建一个具有固定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 创建一个只有一个线程的线程池
//        ExecutorService service = Executors.newSingleThreadExecutor();
        // 创建20个线程
        for (int i = 0; i < 20; i++) {
            final int n = i;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程编号为： " + n + "开始了");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程编号为： " + n + "结束了");
                }
            };
            service.submit(r);
        }
        service.shutdown();
    }
}
