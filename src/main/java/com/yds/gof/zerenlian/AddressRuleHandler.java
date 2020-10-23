package com.yds.gof.zerenlian;

/**
 * @author Intellij
 * @title: AddressRuleHandler
 * @description: TODO
 * @date 2020/6/16 14:25
 */
public class AddressRuleHandler extends AbstactHandler{

    public AddressRuleHandler() {
        sourceType = "AddressRuleHandler";
    }

    @Override
    String process(RequestParam requestParam) {
        System.out.println("AddressRuleHandler...");
        return "ok2";
    }
}
