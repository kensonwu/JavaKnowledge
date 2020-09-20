package com.kenson.thread03.status.join;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestJoin {
    public static void main(String[] args) throws InterruptedException {
        JoinThread join = new JoinThread();
        Thread thread = new Thread(join);
        thread.start();
        for (int i = 0; i <1000; i++) {
            if (50 == i) {
                // 子线程加入到主线程导致主线程阻塞
                thread.join();
            }
            System.out.println("main thread...." + i);
        }
    }
}
