package com.learn.functionCode;

/**
 * @author yds
 * @title: MessageBuilder
 * @description: TODO
 * @date 2021/3/2 17:37
 */
@FunctionalInterface
public interface MessageBuilder {
    /**
     * 信息生成器
     * @return 生成的信息
     */
    public abstract String builderMessage();
}
