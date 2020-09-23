package com.kenson.thread09.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @description: 使用ForkJoin框架计算1到一个数的和
 * 主要是拆分任务，提高计算效率，减少计算时间
 * @author: Kenson
 * @date: 2020/9/23
 */
public class SumTask extends RecursiveTask<Long> {
    // 开始的数
    private int start;
    // 结束的数
    private int end;
    // 计算的步数
    private int step = 20000;//最小拆分成几个数相加

    public SumTask() {
    }

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sumResult = 0;
        if (end - start < step) {// 不能拆分后直接求和
            for (int i = start; i < end; i++) {
                // 小于5个数，直接求和
                sumResult += i;
            }
        } else {
            // 大于5个数继续拆分
            int mid = (end + start) / 2;//求出中间数
            SumTask leftSumTask = new SumTask(start, mid);
            SumTask rightSumTask = new SumTask(mid + 1, end);

            // 执行子任务
            leftSumTask.fork();
            rightSumTask.fork();
            // 子任务执行完成，得到执行结果
            Long leftTaskResult = leftSumTask.join();
            Long rightTaskResult = rightSumTask.join();
            sumResult = leftTaskResult + rightTaskResult;
        }

        return sumResult;
    }
}
