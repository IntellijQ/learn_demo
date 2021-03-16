package com.learn.jvm.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * @author yds
 * @title: TwoPrintThread
 * @description: TODO
 * @date 2021/3/7 18:45
 */
public class TwoPrintThread {

    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {
//        wait_otify();
        count_locksupport();
    }



    private static void count_locksupport(){
        t1 = new Thread(() ->{
            for (int i = 0; i < 26; i++) {
                // 让当前线程释放锁资源，进入wait状态
                LockSupport.park();

                // 打印字母A-Z
                System.out.print((char) ('A' + i));
                // 唤醒其他在等待的线程
                LockSupport.unpark(t2);
            }
        }, "打印字母");


        t2 = new Thread(() ->{
            for (int i = 0; i < 26; i++) {
                //打印数字1-26
                System.out.print((i + 1));
                // 唤醒其他在等待的线程
                LockSupport.unpark(t1);

                // 让当前线程释放锁资源，进入wait状态
                LockSupport.park();
            }
        }, "打印数字");

        t1.start();
        t2.start();
    }

    private static void wait_otify() {
        Object lock = new Object();
        new Thread(() ->{
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    try {
                        // 让当前线程释放锁资源，进入wait状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 打印字母A-Z
                    System.out.print((char) ('A' + i));
                    // 唤醒其他在等待的线程
                    lock.notify();
                }
            }
        }, "打印字母").start();

        new Thread(() ->{
            synchronized (lock) {
                for (int i = 0; i < 26; i++) {
                    //打印数字1-26
                    System.out.print((i + 1));
                    // 唤醒其他在等待的线程
                    lock.notify();
                    try {
                        // 让当前线程释放锁资源，进入wait状态
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "打印数字").start();
    }

}
