package com.kenson.thread01.createthread.implementcallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: 测试线程池大量执行Callable
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestRace {
    public static void main(String[] args) {
        // 创建一个可伸缩数量的线程池
//        ExecutorService service = Executors.newCachedThreadPool();
        // 创建一个只有一个线程的线程池
//        ExecutorService service = Executors.newSingleThreadExecutor();
        // 创建一个具有固定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        Race rabbit = new Race("小白兔", 500); // 每隔0.5秒跑一步
        Race tortoise = new Race("老乌龟", 1000);// 每隔1秒跑一步
        Future<Integer> result1 = service.submit(rabbit);
        Future<Integer> result2 = service.submit(tortoise);
        try {
            // 让主线程运行10秒后在设置线程的flag为false
            Thread.sleep(10000);
            rabbit.setFlag(false);
            tortoise.setFlag(false);
            Integer step1 = result1.get();
            Integer step2 = result2.get();
            System.out.println("小白兔跑了 ： " + step1 + "步");
            System.out.println("老乌龟跑了 ： " + step2 + "步");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 停止线程
        service.shutdownNow();
    }
}
