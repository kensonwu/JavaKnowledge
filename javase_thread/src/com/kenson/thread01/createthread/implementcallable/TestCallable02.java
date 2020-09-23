package com.kenson.thread01.createthread.implementcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/23
 */
public class TestCallable02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable02 tc = new TestCallable02();
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                String[] strs = {"Apple", "Pear", "Watermelon", "Banana", "Grape", "Peach"};
                int idx = (int) (Math.random() * 6);
                return strs[idx];
            }
        };
        FutureTask<String> ft = new FutureTask<>(callable);
        new Thread(ft, "Callale线程").start();
        String result = ft.get();
        System.out.println("返回的结果为： " + result);

    }
}
