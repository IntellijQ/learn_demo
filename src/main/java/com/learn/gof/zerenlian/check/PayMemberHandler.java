package com.learn.gof.zerenlian.check;

/**
 * @author yds
 * @title: CheckCardInfoHandler
 * @description: 查询会员卡信息
 * @date 2020/6/19 16:22
 */
public class PayMemberHandler implements OpenCardAbstractHandler {
    @Override
    public void handleReuquest() {
        System.out.println("PayMemberHandler");
    }
}
