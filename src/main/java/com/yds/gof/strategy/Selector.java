package com.yds.gof.strategy;

/**
 * @author yds
 * @title: Selector
 * @description: TODO
 * @date 2020/6/22 16:54
 */
public class Selector implements StrategyContext{
    Strategy strategy;
    @Override
    public StrategyContext setStategy(Strategy stategy) {
        strategy = stategy;
        return this;
    }

    @Override
    public void deal() {
        strategy.request();
    }
}
