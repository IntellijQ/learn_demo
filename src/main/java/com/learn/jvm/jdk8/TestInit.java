package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestInit
 * @description: TODO
 * @date 2020/12/21 16:28
 */
public class TestInit {
    static {
        age = 15;
//        System.out.println(age);
    }
    private static int age = 10;

    static {
        System.out.println(age);
    }
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "start");
                II tt = new II();
                System.out.println(Thread.currentThread().getName() + "end");
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread.start();
        thread2.start();

        System.out.println(age);
    }

    static class II{
        static {

            if (true){
                System.out.println(Thread.currentThread().getName() + "init II 中。。。");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
