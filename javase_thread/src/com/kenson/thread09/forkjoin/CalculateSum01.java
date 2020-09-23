package com.kenson.thread09.forkjoin;

/**
 * @description: 使用for循环求1到一个数的和所用的时间
 * @author: Kenson
 * @date: 2020/9/23
 */
public class CalculateSum01 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long sumResult = 0;
        for (int i = 0; i < 1000000000; i++) {
            sumResult += i;
        }
        System.out.println("1到1000000000的和为："+ sumResult);
        long endTime = System.currentTimeMillis();
        System.out.println("求1到1000000000的和，for循环所用时间为：" + (endTime - startTime) + "毫秒");

    }
}
