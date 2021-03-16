package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestUseTLAB
 * @description: -XX:+UseTLAB
 * @date 2020/12/25 16:23
 */
public class TestUseTLAB {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("test use TLAB");
        Thread.sleep(1000000);
    }
}
