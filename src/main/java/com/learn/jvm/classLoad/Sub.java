package com.learn.jvm.classLoad;

/**
 * @author yds
 * @title: Sub
 * @description: TODO
 * @date 2021/4/8 16:21
 */
public class Sub extends Parent{
    public static int B = A;

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
