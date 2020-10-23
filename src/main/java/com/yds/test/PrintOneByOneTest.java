package com.yds.test;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yds
 * @title: PrintOneByOneTest
 * @description: TODO
 * @date 2020/5/2218:13
 */
public class PrintOneByOneTest {

    private static String[] one = {"1","2","3","4","5","6"};
    private static String[] two = {"A","B","C","D","E","F"};
    static Thread threadOne = null;
    static Thread threadTwo = null;

    public static void main(String[] args) {
        park();

    }


    private static void park(){
        threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(String str : one){
                    System.out.println(Thread.currentThread().getName() + ":" + str);
                    LockSupport.unpark(threadTwo);
                    LockSupport.park();

                }
            }
        });

        threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(String str : two){
                    System.out.println(Thread.currentThread().getName() + ":" + str);
                    LockSupport.unpark(threadOne);
                    LockSupport.park();

                }
            }
        });

        threadOne.start();
        threadTwo.start();

    }


    private static void wait_notify(){
        Object o = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for(String str : one){
                        try {
//                            System.out.println(Thread.currentThread().getName() + ":得到锁");
                            System.out.println(Thread.currentThread().getName() + ":" + str);
                            o.notifyAll();
//                            System.out.println(Thread.currentThread().getName() + ":自己停下，唤醒他人");
                            o.wait();
//                            System.out.println(Thread.currentThread().getName() + ":wait 结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notifyAll();
                }
            }
        },"线程one").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for(String str : two){
                        try {
//                            System.out.println(Thread.currentThread().getName() + ":得到锁");
                            System.out.println(Thread.currentThread().getName() + ":" + str);
                            o.notifyAll();
//                            System.out.println(Thread.currentThread().getName() + ":自己停下，唤醒他人");
                            o.wait();
//                            System.out.println(Thread.currentThread().getName() + ":wait 结束");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notifyAll();
                }
            }
        },"线程two").start();
    }
}
