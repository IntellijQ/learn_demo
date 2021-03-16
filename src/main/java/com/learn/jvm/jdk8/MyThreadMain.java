package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: MyThreadMain
 * @description: TODO
 * @date 2021/3/8 17:15
 */
public class MyThreadMain {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        thread.interrupt();
    }
}
