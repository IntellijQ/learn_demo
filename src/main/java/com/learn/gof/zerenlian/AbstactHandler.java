package com.learn.gof.zerenlian;

/**
 * @author Intellij
 * @title: AbstactHandler
 * @description: TODO
 * @date 2020/6/16 20:18
 */
public abstract class AbstactHandler implements RuleHandler {
    String sourceType;
    RuleHandler nextRuleHandler;

    public String getSourceType() {
        return sourceType;
    }

    public RuleHandler getNextRuleHandler() {
        return this.nextRuleHandler;
    }

    public RuleHandler setNextRuleHandler(RuleHandler nextRuleHandler) {
        this.nextRuleHandler = nextRuleHandler;
        return this;
    }

    @Override
    public String handleRquest(RequestParam requestParam) {
        System.out.println("当前执行RULE:" + this + ",下一个RULE：" + getNextRuleHandler());
        if(requestParam.getSourceType() == this.getSourceType()){
            process(requestParam);
        }else{
            if(getNextRuleHandler() != null){
                getNextRuleHandler().handleRquest(requestParam);
            }
        }
        return "结束";
    }

    abstract String process(RequestParam requestParam);
}
