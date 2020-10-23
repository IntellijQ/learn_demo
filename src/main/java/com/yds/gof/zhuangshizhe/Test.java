package com.yds.gof.zhuangshizhe;

/**
 * @author Intellij
 * @title: Test
 * @description: 装饰者模式
 *
 * @date 2020/6/12 11:50
 */
public class Test {
    public static void main(String[] args) {
        Text text = new TextImpl();
        text = new Decotator(text);
        BlodDecorator blodDecorator = new BlodDecorator(text);
        String ddd = blodDecorator.blod("ddd");
        System.out.println(ddd);
    }
}
