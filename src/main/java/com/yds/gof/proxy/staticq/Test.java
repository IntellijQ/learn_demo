package com.yds.gof.proxy.staticq;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/6/22 16:43
 */
public class Test {
    public static void main(String[] args) {
        ProxyImpl proxy = new ProxyImpl(new RealSubject());
        proxy.request();
    }
}
