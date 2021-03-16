package com.learn.jvm.thread;

/**
 * @author yds
 * @title: Thread1
 * @description: TODO
 * @date 2020/12/16 17:09
 */
public class Thread1Exends extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ",我是Thread1Exends");
    }
}
