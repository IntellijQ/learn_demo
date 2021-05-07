package com.learn.jvm.classLoad;

/**
 * @author yds
 * @title: Parent
 * @description: TODO
 * @date 2021/4/8 16:20
 */
public class Parent {
    public static int A = 1;
    static {
        A = 2;
    }
}
