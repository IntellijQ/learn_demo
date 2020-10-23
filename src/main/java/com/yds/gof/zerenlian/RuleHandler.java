package com.yds.gof.zerenlian;

/**
 * @author Intellij
 * @title: RuleHandler
 * @description: TODO
 * @date 2020/6/16 14:18
 */
public interface RuleHandler {
    RuleHandler getNextRuleHandler();

    RuleHandler setNextRuleHandler(RuleHandler nextRuleHandler);

    String handleRquest(RequestParam requestParam);
}
