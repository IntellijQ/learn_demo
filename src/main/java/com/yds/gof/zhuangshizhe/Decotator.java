package com.yds.gof.zhuangshizhe;

/**
 * @author Intellij
 * @title: Decotator
 * @description: TODO
 * @date 2020/6/12 11:44
 */
public class Decotator implements Text{
    private Text text;
    public Decotator(Text text) {
        this.text = text;
    }

    @Override
    public String getContext() {
        return text.getContext();
    }

    @Override
    public void setContext(String context) {
        text.setContext(context);
    }
}
