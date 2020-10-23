package com.learn.jvm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yds
 * @title: Test_001_WaitNotify_LockSupport_ReetrantLock
 * @description: TODO
 * @date 2020/5/922:13
 */
public class Test_001_WaitNotify_LockSupport_ReetrantLock {

    static Thread ta = null;
    static Thread tb = null;

    static String[] a = {"A","B","C","D","E"};
    static String[] b = {"1","2","3","4","5"};


    public static void main(String[] args) {
        park_unpark();
//        wait_notify();
//        reentrantLock();

    }


    private static void park_unpark(){
        ta = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< a.length; i++){
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" +a[i]);
                        LockSupport.unpark(tb);//一启动就叫醒另外一个
                        LockSupport.park();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        tb = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< b.length; i++){
                    try {
                        LockSupport.park();//一启动就暂定
                        System.out.println(Thread.currentThread().getName() + ":" +b[i]);
                        LockSupport.unpark(ta);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        ta.start();
        tb.start();
    }

    private static void wait_notify(){
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for(int i = 0; i< a.length; i++){
                        try {
                            o.wait();
                            System.out.println("Thread-0 获得锁了");
                            System.out.println(Thread.currentThread().getName() + ":" +a[i]);
                            o.notify();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }

            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    for(int i = 0; i< b.length; i++){
                        try {
                            o.notify();
                            System.out.println("Thread-1 获得锁了");
                            System.out.println(Thread.currentThread().getName() + ":" +b[i]);
                            o.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }

            }
        }).start();
    }


    private static void reentrantLock(){
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for(int i = 0; i< b.length; i++){
                        condition1.await();
                        System.out.println(Thread.currentThread().getName() + ":" +b[i]);
                        condition2.signal();
                    }
                    condition2.signal();
                }catch (Exception ex){

                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for(int i = 0; i< a.length; i++){
                        condition1.signal();
                        System.out.println(Thread.currentThread().getName() + ":" +a[i]);
                        condition2.await();
                    }
                    condition1.signal();
                }catch (Exception ex){

                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }

}
