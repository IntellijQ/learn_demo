package com.yds.test.classLoad;

/**
 * @author yds
 * @title: SuperClass
 * @description: TODO
 * @date 2020/5/2113:56
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    public static int age = 10;
    public static final String SEX = "男";
}
