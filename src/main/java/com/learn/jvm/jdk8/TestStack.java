package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestStack
 * @description: TODO
 * @date 2020/12/24 14:48
 */
public class TestStack {
    private int a;
    public int test(){
//        a = 9;
        byte i = 125;
        int j = 3452;
        int k =i + j;
        return k;
    }


    public void test1(){
//        a = 9;
        int i = test();
    }

    public void dd(){
        int a = 1;
        a++;
    }

    public void dd1(){
        int a = 1;
        ++a;
    }
}
