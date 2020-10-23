package com.yds.gof.zerenlian;

/**
 * @author Intellij
 * @title: BankRuleHandler
 * @description: TODO
 * @date 2020/6/16 14:25
 */
public class BankRuleHandler extends AbstactHandler{

    public BankRuleHandler() {
        sourceType = "BankRuleHandler";
    }

    @Override
    String process(RequestParam requestParam) {
        System.out.println("BankRuleHandler...");
        return "ok";
    }
}
