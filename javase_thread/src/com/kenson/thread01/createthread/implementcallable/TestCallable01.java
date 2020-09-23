package com.kenson.thread01.createthread.implementcallable;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @description: 测试使用Callable接口实现多线程
 * @author: Kenson
 * @date: 2020/9/23
 */
public class TestCallable01 implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable01 tc = new TestCallable01(); //创建任务

        /**
         * FutureTask 实现了 RunnableFuture， RunnableFuture接口继承了Runnable和Future接口
         * 而启动线程有需要Thread, Thread类中构造函数有一个需要Runnable接口
         * 所以这里向上转型就能给第给Thread类了
         */
        FutureTask<String> ft = new FutureTask<>(tc);// 将任务交给任务管理器
        new Thread(ft, "Callabel线程1").start();
        String result = ft.get();
        System.out.println("线程执行返回的结果为：" + result);
    }

    @Override
    public String call() throws Exception {
        String[] strs = {"Apple", "Pear", "Watermelon", "Banana", "Grape", "Peach"};
        int idx = (int) (Math.random() * 6);
        return strs[idx];
    }

}
