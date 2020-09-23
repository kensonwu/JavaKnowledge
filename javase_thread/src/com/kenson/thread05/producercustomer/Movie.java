package com.kenson.thread05.producercustomer;

/**
 * @description: 一份共同的资源， 电影资源
 * 这种方式就是使用的同步方法
 * 因为电影是一个共享资源，很多线程都会对它进行操作，为了保证安全以及数据不错乱所以此时使用的同步方法就锁定共同操作的资源
 * 使用同步方法的话，那么就只能把同步放到共享资源里内
 * 电影这个资源具备两个功能， 1.生产电影 2，消费电影
 * 观看电影的场景：它播放什么， 我们就看什么
 * 使用生产者消费者模式， 信号灯法
 * Java中提供了3个方法解决线程之间的通信问题：
 * final void wait() 等待, 表示线程一直等待，直到其他线程通知，  释放锁
 * void wait(long timeout) 线程等待指定毫秒参数的时间，释放锁
 * final void wait(long timeout, int nanos) 线程等待指定毫秒、微妙的时间
 * final void notify() 唤醒一个处于等待状态的线程
 * final void notifyAll() 唤醒同一个对象上所有调用wait()方法的线程，优先级别高的线程有限运行
 * wait(), notify(), notifyAll()这三个方法都是java.lang.Object类的中方法，只能用于同步方法或同步代码块中使用，否则会抛出异常
 * static native void sleep(long millis) 休眠指定毫秒的时间 不会释放锁
 * @author: Kenson
 * @date: 2020/9/22
 */
public class Movie {
    /**
     * 定义一个flag来控制什么时候生产电影，什么时候消费电影
     * 规则：
     * flag==true， 生产者生产， 消费者等待，生产完后通知消费者
     * flag==flase，生产者等待， 消费者消费，消费完后通知生产者
     */
    private boolean flag = true;

    // 影片
    private String vedio;

    /**
     * 生产者
     * 生产电影影片
     *
     * @param vedio
     */
    public synchronized void produceMovie(String vedio) {
        if (!flag) { // 生产者等待
            try {
                this.wait(); // 生产者等待， 释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 开始生产, 假如让线程生产1秒
        try {
            Thread.sleep(10000); // 不释放锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("生产了影片： " + vedio);

        // 生产完毕
        this.vedio = vedio;

        // 生产完成之后，通知消费者去消费
        this.notifyAll();

        // 生产者停止生产
        this.flag = false;
    }

    /**
     * 消费者
     * 消费电影影片
     */
    public synchronized void customMovie() {
        if (flag) { // 消费者等待
            try {
                this.wait(); //等待, 释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 开始消费
        try {
            // 消费0.5秒
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消费了：" + vedio);
        // 完成消费
        // 通知生产者
        this.notifyAll();
        // 停止消费
        this.flag = true;
    }

}
