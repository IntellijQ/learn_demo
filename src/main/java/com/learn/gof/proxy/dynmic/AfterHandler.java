package com.learn.gof.proxy.dynmic;

import java.lang.reflect.Method;

/**
 * @author yds
 * @title: AfterHandler
 * @description: TODO
 * @date 2020/6/22 16:49
 */
public class AfterHandler extends AbstractHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("after...");
        return null;
    }
}
