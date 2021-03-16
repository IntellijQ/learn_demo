package com.learn.jvm.thread;

/**
 * @author yds
 * @title: ThreadRunable
 * @description: TODO
 * @date 2020/12/16 17:10
 */
public class ThreadImplements implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "我是ThreadImplements");
    }
}
