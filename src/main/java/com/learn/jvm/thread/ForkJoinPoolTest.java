package com.learn.jvm.thread;

import java.util.concurrent.*;

/**
 * @author yds
 * @title: ForkJoinPoolTest
 * @description: TODO
 * @date 2021/3/15 10:36
 */
public class ForkJoinPoolTest {

    private static final Integer MAX = 10;

    static class MyForkIjoinTask extends RecursiveTask<Integer> {
        private Integer startValue;
        private Integer endValue;

        public MyForkIjoinTask(Integer startValue, Integer endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        protected Integer compute() {
            if (this.endValue - this.startValue < MAX) {
                Integer sum = 0;
                for (int i = this.startValue; i <= this.endValue; i++) {
                    sum += i;
                }
                System.out.println("开始部分计算：startValue=" + this.startValue + ",endValue=" + this.endValue + ",sum=" + sum);
                return sum;
            } else {
                MyForkIjoinTask myForkIjoinTask = new MyForkIjoinTask(this.startValue, (this.startValue + this.endValue) / 2);
                myForkIjoinTask.fork();
                MyForkIjoinTask myForkIjoinTask1 = new MyForkIjoinTask((this.startValue + this.endValue) / 2 + 1, this.endValue);
                myForkIjoinTask1.fork();
                int i = myForkIjoinTask.join();
                int j = myForkIjoinTask1.join();
                return i + j;
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(new MyForkIjoinTask(1, 20));
        Integer integer = forkJoinTask.get();
        System.out.println("result=" + integer);
    }
}
