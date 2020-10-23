package com.learn.gof.proxy.dynmic;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/6/27 14:53
 */
public class Test {
    public static void main(String[] args) {
        AbstractHandler abstractHandler = new AfterHandler();
        abstractHandler.set(new Object());
    }
}
