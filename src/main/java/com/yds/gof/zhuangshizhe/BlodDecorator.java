package com.yds.gof.zhuangshizhe;

/**
 * @author Intellij
 * @title: BlodDecorator
 * @description: 字体加粗实现
 * @date 2020/6/12 11:46
 */
public class BlodDecorator extends Decotator {
    public BlodDecorator(Text text) {
        super(text);
    }

    public String blod(String data){
        return "<b>" + data + "</b>";
    }
}
