package com.learn.jvm.jdk8;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author yds
 * @title: TestObjectMarkWord
 * @description: 测试对象头信息
 * @date 2020/12/29 10:58
 */
public class TestObjectHead {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        //查看对象外部信息
        System.out.println(GraphLayout.parseInstance(obj).toPrintable());
    }
}
