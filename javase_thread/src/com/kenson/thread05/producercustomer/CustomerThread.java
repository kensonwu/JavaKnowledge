package com.kenson.thread05.producercustomer;

/**
 * @description: 消费者线程
 * 消费电影资源
 * @author: Kenson
 * @date: 2020/9/22
 */
public class CustomerThread implements Runnable {
    private Movie movie;

    public CustomerThread(Movie movie) {
        this.movie = movie;
    }

    /**
     * 线程体
     * 模拟消费电影影片资源
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            movie.customMovie();
        }
    }
}
