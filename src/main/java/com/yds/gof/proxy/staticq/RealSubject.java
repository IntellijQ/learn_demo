package com.yds.gof.proxy.staticq;

/**
 * @author yds
 * @title: RealSubject
 * @description: TODO
 * @date 2020/6/22 16:41
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("RealSubject...");
    }
}
