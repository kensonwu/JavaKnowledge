package com.kenson.thread03.status.join;

/**
 * @description: join:合并线程
 * @author: Kenson
 * @date: 2020/9/20
 */
public class JoinThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Run......" + i);
        }
    }
}
