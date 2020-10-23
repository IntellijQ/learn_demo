package com.yds.gof.singleton;

/**
 * @author yds
 * @title: SingletonTest
 * @description: TODO
 * @date 2020/5/2815:40
 */
public class SingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Singleton4Enum singleton1 =  Singleton4Enum.INSTANCE;
                    System.out.println(String.format("当前线程：%s,实例信息：%s,对用属性：%s",
                            Thread.currentThread().getName(),singleton1.hashCode(),singleton1.toString()));
                }
            },"线程" + i).start();
        }
    }
}
