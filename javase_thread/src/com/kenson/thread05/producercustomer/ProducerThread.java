package com.kenson.thread05.producercustomer;

/**
 * @description: 生产者线程体
 * 生产者生产的是电影影片资源
 * @author: Kenson
 * @date: 2020/9/22
 */
public class ProducerThread implements Runnable {
    private Movie movie;

    public ProducerThread(Movie movie) {
        this.movie = movie;
    }

    /**
     * 线程体， 模拟生产电影影片资源
     */
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                movie.produceMovie("满城尽带黄金甲" + i);
            } else {
                movie.produceMovie("卧虎藏龙" + i);
            }
        }
    }
}
