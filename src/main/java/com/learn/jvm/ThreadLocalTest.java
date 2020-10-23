package com.learn.jvm;

/**
 * @author yds
 * @title: ThreadLocalTest
 * @description: TODO
 * @date 2020/5/2614:33
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("yds");
    }
}
