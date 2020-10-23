package com.yds.gof.proxy.dynmic;

import java.lang.reflect.InvocationHandler;

/**
 * @author yds
 * @title: AbstractHandler
 * @description: TODO
 * @date 2020/6/22 16:47
 */
public abstract class AbstractHandler implements InvocationHandler {
    Object object;
    public InvocationHandler set(Object object){
        object = object;
        return this;
    }
}
