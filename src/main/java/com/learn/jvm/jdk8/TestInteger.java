package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestInteger
 * @description: TODO
 * @date 2020/12/22 11:20
 */
public class TestInteger {
    public static void main(String[] args) {
//        final
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//true
        System.out.println(g.equals(a + b));//false
    }
}
