package com.learn.jvm.classLoad;

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

    int score = 150;

    public SubClass() {
        print();
        score = 170;
    }

    public void print(){
        System.out.println("Sub score = " + score);
    }

    public static void main(String[] args) {
        SuperClass subClass = new SubClass();
        System.out.println(subClass.score);
    }
}
