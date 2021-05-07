package com.learn.jvm;

/**
 * @author yds
 * @title: SynchronizedTest
 * @description: TODO
 * @date 2021/4/14 13:54
 */
public class SynchronizedTest {

    public synchronized void test1(){

    }

    public synchronized  static void test2(){

    }


    public void dd(){
        Object o = new Object();
        synchronized (o){

        }
    }
}
