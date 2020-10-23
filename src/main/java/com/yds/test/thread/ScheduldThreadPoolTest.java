package com.yds.test.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yds
 * @title: ScheduldThreadPoolTest
 * @description: TODO
 * @date 2020/5/2914:38
 */
public class ScheduldThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }, 1, TimeUnit.SECONDS);

        System.out.println("Runnable future's result is: " + schedule.get());
    }
}
