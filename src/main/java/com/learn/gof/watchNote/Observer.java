package com.learn.gof.watchNote;

/**
 * @author yds
 * @title: Observer
 * @description: TODO
 * @date 2021/4/22 15:10
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
