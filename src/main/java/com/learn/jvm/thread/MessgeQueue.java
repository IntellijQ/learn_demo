package com.learn.jvm.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author yds
 * @title: MessgeQueue
 * @description: TODO
 * @date 2021/3/7 20:42
 */
public class MessgeQueue {

    static LinkedList queen = new LinkedList();
    static int size = 0;
    static final int MAX = 10;

    public synchronized void put(String msg) throws InterruptedException {
        while (size == MAX) {
            System.out.println("消息池已满，请稍后生产。。。");
            this.wait();
        }

        queen.addLast(msg);
        size++;
        System.out.println(Thread.currentThread().getName()+ ",成功生产消息：" + msg + "，当前消息数：" + size);
        this.notifyAll();
    }

    public synchronized String get() throws InterruptedException {
        while (size == 0) {
            System.out.println("无消息可用，请稍后。。。");
            this.wait();
        }
        String msg = (String)queen.removeFirst();
        size--;
        System.out.println(Thread.currentThread().getName()+ ",消费消息：" + msg + "，当前消息数：" + size);
        this.notifyAll();
        return msg;
    }


    public static void main(String[] args) {

        MessgeQueue messgeQueue = new MessgeQueue();

        Thread product = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        messgeQueue.put("msg " + new Random().nextInt());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }, "生产线程" );
        product.start();

        for (int i = 0; i < 10; i++) {
            Thread cousumer = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            String s = messgeQueue.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            },"消费线程" + i);
            cousumer.start();
        }
    }
}
