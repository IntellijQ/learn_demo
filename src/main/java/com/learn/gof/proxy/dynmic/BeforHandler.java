package com.learn.gof.proxy.dynmic;

import java.lang.reflect.Method;

/**
 * @author yds
 * @title: BeforHandler
 * @description: TODO
 * @date 2020/6/22 16:48
 */
public class BeforHandler extends AbstractHandler{
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        return null;
    }
}
