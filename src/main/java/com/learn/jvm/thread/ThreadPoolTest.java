package com.learn.jvm.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yds
 * @title: ThreadPoolTest
 * @description: TODO
 * @date 2021/3/14 9:42
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run...");
            }
        });


        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println("call..");
                return null;
            }
        });
    }
}
