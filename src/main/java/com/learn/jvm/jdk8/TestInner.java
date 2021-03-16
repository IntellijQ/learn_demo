package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestInner
 * @description: TODO
 * @date 2021/3/8 23:42
 */
public class TestInner {
    public static void main(String[] args) {
//        String ab ="ab";
//        String ab2 = new String("ab");

        String cc = new String("a")  + new String ("b");
        cc.intern();
        String dd = "ab";

        System.out.println(cc == dd);
//        System.out.println(intern == "ab");
    }
}
