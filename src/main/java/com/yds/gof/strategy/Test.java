package com.yds.gof.strategy;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/6/22 16:55
 */
public class Test {
    public static void main(String[] args) {
        StrategyContext selector = new Selector();
        selector.setStategy(new WayOneStrategy()).deal();
    }
}
