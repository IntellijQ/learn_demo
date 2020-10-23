package com.yds.test.classLoad;

/**
 * @author yds
 * @title: SubClass
 * @description: TODO
 * @date 2020/5/2113:56
 */
public class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }
}
