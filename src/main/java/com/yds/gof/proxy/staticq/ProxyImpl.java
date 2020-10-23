package com.yds.gof.proxy.staticq;

/**
 * @author yds
 * @title: ProxyImpl
 * @description: TODO
 * @date 2020/6/22 16:41
 */
public class ProxyImpl implements Subject {
    private RealSubject realSubject;

    public RealSubject getRealSubject() {
        return realSubject;
    }

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public ProxyImpl(RealSubject realSubject) {
        this.realSubject = realSubject;
    }


    @Override
    public void request() {
        System.out.println("before...");
        realSubject.request();
        System.out.println("after...");
    }
}
