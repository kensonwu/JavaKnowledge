package com.kenson.thread03.status.join;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestStudyThread {
    public static void main(String[] args) throws InterruptedException {
        // 真实线程类
        StudyThread st = new StudyThread();
        // Thread
        Thread thread = new Thread(st);
        //启动线程
        thread.start();
        // 主线程等待子线程执行一会儿
        Thread.sleep(10);
        // 停止线程执行
        st.stop();
    }
}
