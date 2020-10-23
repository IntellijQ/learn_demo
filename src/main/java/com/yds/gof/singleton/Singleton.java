package com.yds.gof.singleton;

/**
 * @author yds
 * @title: Singleton
 * @description: 饿汉单例
 * @date 2020/5/2816:32
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){

    }

    public static Singleton newInstance(){
        return singleton;
    }
}
