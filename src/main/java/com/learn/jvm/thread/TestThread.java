package com.learn.jvm.thread;

/**
 * @author yds
 * @title: TestThread
 * @description: TODO
 * @date 2020/12/16 17:10
 */
public class TestThread {

    void m(){
        System.out.println(Thread.currentThread().getName() + "哈哈哈");
    }

    public static void main(String[] args) {


        Thread1Exends thread1Exends = new Thread1Exends();
        thread1Exends.setName("11");
        thread1Exends.start();

        Thread1Exends thread1Exends2 = new Thread1Exends();
        thread1Exends2.setName("22");
        thread1Exends2.start();


        ThreadImplements threadImplements3 = new ThreadImplements();
        Thread thread3 = new Thread(threadImplements3,"33");
        thread3.start();


        ThreadImplements threadImplements4 = new ThreadImplements();
        Thread thread4 = new Thread(threadImplements4,"44");
        thread4.start();


        TestThread testThread5 = new TestThread();
        new Thread(testThread5::m,"55").start();

        new Thread("6666") {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "qwqwqwq");
            }
        }.start();

    }
}
