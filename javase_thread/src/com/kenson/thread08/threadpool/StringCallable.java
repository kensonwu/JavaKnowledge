package com.kenson.thread08.threadpool;

import java.util.concurrent.Callable;

/**
 * @description: StringCallable 线程
 * @author: Kenson
 * @date: 2020/9/23
 */
public class StringCallable implements Callable {
    @Override
    public Object call() throws Exception {
        String[] fruits = {"Bagasse", "Banana", "Bennet", "Bergamot", "Berry", "Betelnut"};
        int idx = (int) (Math.random() * 6);
        Thread.sleep(1000);
        return fruits[idx];
    }
}
