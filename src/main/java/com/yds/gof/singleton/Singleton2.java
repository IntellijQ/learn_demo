package com.yds.gof.singleton;

import java.util.Random;
import java.util.UUID;

/**
 * @author yds
 * @title: Singleton
 * @description: 懒汉单例 ---多线程会有问题
 * @date 2020/5/2816:32
 */
public class Singleton2 {
    private static Singleton2 singleton;
    private Singleton2(){

    }


    public static Singleton2 newInstance(){
        if(singleton == null){
            singleton = new Singleton2();
        }
        return singleton;
    }
}
