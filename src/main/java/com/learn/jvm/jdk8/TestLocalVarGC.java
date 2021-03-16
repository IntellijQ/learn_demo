package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestLocalVarGC
 * @description: TODO
 * @date 2020/12/30 17:05
 */
public class TestLocalVarGC {
    public static void main(String[] args) {

        TestLocalVarGC testLocalVarGC = new TestLocalVarGC();
        testLocalVarGC.test1();
    }

    public void test1(){
        byte[] byte2s = new byte[1024 * 1024 *1000000];
        {
           byte[] bytes = new byte[1024 * 1024 *10000000];
        }
        int age = 10;
//        String name = "dd";
//        System.gc();
    }
}
