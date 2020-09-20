package com.kenson.thread01.createthread.implementcallable;

import java.util.concurrent.Callable;

/**
 * @description: 使用Callable创建线程
 * 使用这种方式创建线程， 可以对外申明异常，同时也可以返回值
 * @author: Kenson
 * @date: 2020/9/20
 */
public class Race implements Callable<Integer> {

    private String name; // 名称
    private long time; // 延时时间
    private boolean flag = true;
    private int step = 0; // 跑的步数

    public Race() {
    }

    public Race(String name) {
        this.name = name;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public Race(String name, long time, boolean flag, int step) {
        this.name = name;
        this.time = time;
        this.flag = flag;
        this.step = step;
    }


    @Override
    public Integer call() throws Exception {
        // 方法体
        while (flag) {
            Thread.sleep(time);
            step++;
        }
        return step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
