package com.learn.jvm.jdk8;

import java.util.Random;

/**
 * @author yds
 * @title: TestUser
 * @description:
 * @date 2021/1/5 14:52
 */
public class TestUser {
    public static void main(String[] args) {
        System.out.println(User.age2);
    }
}

class User{
    static{
        System.out.println("User 初始化");
    }
    public static int age = 101;
    public static final int age2 = 105;
    public static final int age3 = new Random().nextInt();
}