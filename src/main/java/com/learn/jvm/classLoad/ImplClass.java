package com.learn.jvm.classLoad;

/**
 * @author yds
 * @title: ImplClass
 * @description: TODO
 * @date 2020/5/2114:13
 */
public class ImplClass implements InterfaceClass{
    static {
        System.out.println("ImplClass init");
    }
}
