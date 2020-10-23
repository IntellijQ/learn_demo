package com.learn.gof.zhuangshizhe;

/**
 * @author Intellij
 * @title: ColorDecorator
 * @description: 字体颜色实现
 * @date 2020/6/12 11:46
 */
public class ColorDecorator extends Decotator {
    public ColorDecorator(Text text) {
        super(text);
    }

    public String setColor(String data){
        return "<color>" + data + "</color>";
    }
}
