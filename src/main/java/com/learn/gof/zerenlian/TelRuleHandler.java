package com.learn.gof.zerenlian;

/**
 * @author Intellij
 * @title: TelRuleHandler
 * @description: TODO
 * @date 2020/6/16 14:25
 */
public class TelRuleHandler extends AbstactHandler{

    public TelRuleHandler() {
        sourceType = "TelRuleHandler";
    }

    @Override
    String process(RequestParam requestParam) {
        System.out.println("TelRuleHandler...");
        return "ok";
    }
}
