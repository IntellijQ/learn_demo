package com.learn.jvm.thread.volatile1;

import java.util.concurrent.TimeUnit;

/**
 * @author yds
 * @title: VolatileTest
 * @description: volatile
 * @date 2020/12/16 17:00
 */
public class VolatileTest {
    /*volatile*/ boolean running = true;
    void m(){
        System.out.println("start");
        while (running){
            // 如果不适用volatle 在while循环中打印语句，的确可能会被结束该方法
            // 原因：println方法 有一个内存和本地缓存同步的过程
            System.out.println("听说我可以被结束");
        }
        System.out.println("m end");
    }
    public static void main(String[] args) {

        VolatileTest volatileTest = new VolatileTest();
        new Thread(volatileTest::m, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileTest.running = false;
    }
}
