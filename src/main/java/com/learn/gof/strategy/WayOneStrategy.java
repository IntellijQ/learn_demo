package com.learn.gof.strategy;

/**
 * @author yds
 * @title: WayOneStrategy
 * @description: TODO
 * @date 2020/6/22 16:53
 */
public class WayOneStrategy implements Strategy{
    @Override
    public void request() {
        System.out.println("WayOneStrategy...");
    }
}
