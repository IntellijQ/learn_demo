package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: MyThread
 * @description: TODO
 * @date 2021/3/8 17:14
 */
public class MyThread extends Thread {
    public void run(){
        super.run();
        try {
            System.out.println("线程开始。。。");
            Thread.sleep(200000);
            System.out.println("线程结束。");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止, 进入catch， 调用isInterrupted()方法的结果是：" + this.isInterrupted());
            e.printStackTrace();
        }

    }
}