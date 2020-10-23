package com.learn.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yds
 * @title: Test_002_CounDownLatch_Future
 * @description: TODO
 * @date 2020/5/1010:00
 */
public class Test_002_CounDownLatch_Future {

    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long l = System.currentTimeMillis();
        cuontDownLatch();
//        future
        System.out.println("main 结束" +(System.currentTimeMillis() - l));
    }

    private static void cuontDownLatch() throws InterruptedException {
        new Thread(new Runnable() {
            int sumA = 0;
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int i = 0; i < 10; i++){
                    sumA ++;
                }
                System.out.println(Thread.currentThread().getName()+",结束=" + sumA);
                countDownLatch.countDown();
            }
        },"库存A").start();


        new Thread(new Runnable() {
            int sumB = 0;
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    sumB ++;
                }
                System.out.println(Thread.currentThread().getName()+",结束=" + sumB);
                countDownLatch.countDown();
            }
        },"库存B").start();

        countDownLatch.await();
    }


    private static void future() throws ExecutionException, InterruptedException {
        List<FutureTask> list = new ArrayList<>();

        FutureTask FutureTask001 = new FutureTask<>(new Callable<Integer>() {
            int sumA = 0;
            @Override
            public Integer call() throws Exception {
                for(int i = 0; i < 10; i++){
                    sumA ++;
                }
                System.out.println(Thread.currentThread().getName()+",结束=" + sumA);
                return sumA;
            }
        });
        list.add(FutureTask001);

        FutureTask futureTask002 = new FutureTask<>(new Callable<Integer>() {
            int sumB = 0;

            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                for (int i = 0; i < 100; i++) {
                    sumB++;
                }
                System.out.println(Thread.currentThread().getName() + ",结束=" + sumB);
                return sumB;
            }
        });
        list.add(futureTask002);

        new Thread(FutureTask001).start();
        new Thread(futureTask002).start();

        Integer sum = 0;

        for(FutureTask futureTask : list){
            Integer o = (Integer) futureTask.get();
            System.out.println(o);
            sum += o;
        }

        System.out.println("总和：" + sum);
    }

}
