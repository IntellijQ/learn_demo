package com.yds.gof.strategy;

/**
 * @author yds
 * @title: WayTwoStrategy
 * @description: TODO
 * @date 2020/6/22 16:53
 */
public class WayTwoStrategy implements Strategy{
    @Override
    public void request() {
        System.out.println("WayTwoStrategy...");
    }
}
