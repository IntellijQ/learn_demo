package com.learn.jvm.jdk8;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author yds
 * @title: CountDownLatch
 * @description: TODO
 * @date 2021/3/8 15:07
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        System.out.println("正在等待所有玩家准备好");


        for(int i = 0; i < latch.getCount(); i++){
            new Thread(new MyThread(latch), "player"+i).start();
        }

        latch.await();
        System.out.println("开始游戏");
    }



    private static class MyThread implements Runnable{
        private CountDownLatch latch ;

        public MyThread(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Random rand = new Random();
                int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                Thread.sleep(randomNum);
                System.out.println(Thread.currentThread().getName()+" 已经准备好了, 所使用的时间为 "+((double)randomNum/1000)+"s");
                latch.countDown();
                System.out.println("还剩余" + latch.getCount() + "玩家未准备");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
