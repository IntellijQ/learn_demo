package com.learn.gof.strategy;

/**
 * @author yds
 * @title: StrategyContext
 * @description: TODO
 * @date 2020/6/22 16:52
 */
public interface StrategyContext {

    StrategyContext setStategy(Strategy stategy);

    void deal();
}
