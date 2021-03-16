package com.learn.jvm.classLoad;

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
    int score = 100;

    public SuperClass() {
        print();
        score = 120;
    }

    public void print(){
        System.out.println("Super score = " + score);
    }
}
