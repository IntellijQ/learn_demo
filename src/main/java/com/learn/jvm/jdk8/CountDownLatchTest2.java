package com.learn.jvm.jdk8;

import java.util.concurrent.CountDownLatch;

/**
 * @author yds
 * @title: CountDownLatchTest2
 * @description: 共5个初始化子线程，6个闭锁扣除点，扣除完毕后，主线程和业务线程才能继续执行
 * @date 2021/3/8 15:21
 */
public class CountDownLatchTest2 {
    static CountDownLatch latch = new CountDownLatch(4);

    /*初始化线程*/
    private static class InitThread implements Runnable {

        public void run() {
            System.out.println("初始任务线程_" + Thread.currentThread().getId()
                    + " ready init work......");
            for (int i = 1; i <= 2; i++) {
                System.out.println("初始任务线程_" + Thread.currentThread().getId()
                        + " ........continue do its work 第" + i + "步");
            }
            latch.countDown();
        }
    }

    /*业务线程等待latch的计数器为0完成*/
    private static class BusiThread implements Runnable {

        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 1; i <= 3; i++) {
                System.out.println("业务线程_" + Thread.currentThread().getId()
                        + " do business-----" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Runnable() {
//            public void run() {
//                try {
////                    Thread.sleep(1000);
//                    System.out.println("Thread_" + Thread.currentThread().getId()
//                            + " 初始化阶段开始第一步");
//                    latch.countDown();
//
//                    System.out.println("初始化阶段开始第二步");
////                    Thread.sleep(1000);
//                    System.out.println("Thread_" + Thread.currentThread().getId()
//                            + " 初始化阶段结束");
//                    latch.countDown();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        new Thread(new BusiThread()).start();

        for (int i = 0; i <= 3; i++) {
            Thread thread = new Thread(new InitThread());
            thread.start();
        }

        latch.await();
        System.out.println("Main do ites work........");
    }
}
