package com.kenson.thread09.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @description: 测试使用ForkJoin框架
 * @author: Kenson
 * @date: 2020/9/23
 */
public class TestForkJoin {
    public static void main(String[] args) {
        // 创建一个线程池
        ForkJoinPool pool = new ForkJoinPool();
        // 定义一个任务， 计算1到1000000000的和
        SumTask sumTask = new SumTask(1, 1000000000);

        long startTime = System.currentTimeMillis();
        Long sumResult = null;
        // 将任务交给线程池
        ForkJoinTask<Long> future = pool.submit(sumTask);
        // 得到结果并输出
        try {
            sumResult = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("1到1000000000的和为："+ sumResult);
        long endTime = System.currentTimeMillis();
        System.out.println("求1到1000000000的和，for循环所用时间为：" + (endTime - startTime) + "毫秒");
    }
}
