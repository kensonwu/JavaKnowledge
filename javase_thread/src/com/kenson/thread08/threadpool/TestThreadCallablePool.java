package com.kenson.thread08.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @description: 试线程池大量执行Callable任务
 * @author: Kenson
 * @date: 2020/9/23
 */
public class TestThreadCallablePool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();// 可伸缩的线程池
//        ExecutorService pool = Executors.newFixedThreadPool(10);//固定10个现成的线程池
//        ExecutorService pool = Executors.newSingleThreadExecutor();// 只有1个线程的线程池
        /**
         *  创建一个存放Future<String>类型的集合用于存放线程的返回类型
         *  这样做是为了提高效率， 如果每次创建线程然后获得结果，这样效率会很低下，
         *  因为每次使用get()不返回值的话，get()后面的代码就不会执行
         */
        List<Future<String>> tasks = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            StringCallable sc = new StringCallable();
            Future<String> rslt = pool.submit(sc);
            tasks.add(rslt);
        }

        // 查看现成的返回值
        for (Future task : tasks) {
            try {
                System.out.println(task.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
//        pool.shutdown();
        pool.shutdownNow();

    }
}
