package com.learn.jvm.jdk8;

import java.lang.reflect.Method;

/**
 * @author yds
 * @title: TestMyClassLoader
 * @description: TODO
 * @date 2021/1/6 15:58
 */
public class TestMyClassLoader {
    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\jiufupro\\jijin\\learn_demo\\target\\classes\\com\\learn\\jvm\\jdk8\\");
        Class clazz = myClassLoader.loadClass("TestHSDB");
        System.out.println("加载此类的类加载器为：" + clazz.getClassLoader().getClass().getName());

        Object o = clazz.newInstance();
        System.out.println(o);
    }
}
