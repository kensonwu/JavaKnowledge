package com.kenson.thread03.status.sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 倒计时 1、倒数十个数，一秒内打印一个
 * @author: Kenson
 * @date: 2020/9/20
 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();
    }

    /**
     * 倒数十个数
     */
    public static void test1() throws InterruptedException {
        int num = 10;
        while (true) {
            System.out.println(num--);
            // 等待1秒
            Thread.sleep(1000);
            // 退出循环的条件
            if (num <= 0) {
                break;
            }
        }
    }

    public static void test2() throws InterruptedException {
        // 目标时间
        Date endTime = new Date(System.currentTimeMillis() + 10 * 100);
        long end = endTime.getTime();
        while (true) {
            // 先输出目标时间，如：高考时间，奥运会开幕时间等
            System.out.println(new SimpleDateFormat("yyyy-MM-dd mm:ss").format(endTime));
            // 构建目标时间的前1秒的时间
            endTime = new Date(endTime.getTime() - 1000);
            // 等待1秒
            Thread.sleep(1000);
            // 10秒以内继续，否则退出
            if (end - 10000 > endTime.getTime()) {
                break;
            }
        }
    }
}
