package com.yds.gof.zerenlian;

/**
 * @author Intellij
 * @title: Test
 * @description: TODO
 * @date 2020/6/16 20:26
 */
public class Test {
    public static void main(String[] args) {
        RequestParam requestParam = new RequestParam();
        requestParam.setSourceType("BankRuleHandler");
        RuleHandler ruleHandler =
                new TelRuleHandler().setNextRuleHandler(
                        new AddressRuleHandler().setNextRuleHandler(
                                new BankRuleHandler().setNextRuleHandler(null)));
        ruleHandler.handleRquest(requestParam);
    }
}
