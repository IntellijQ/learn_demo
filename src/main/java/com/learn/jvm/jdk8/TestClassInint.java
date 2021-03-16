package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestClassInint
 * @description: TODO
 * @date 2021/1/6 17:33
 */
public class TestClassInint{

    public static void main(String[] args) throws Exception {
//        当通过子类引用父类的静态变量，不会导致子类初始化
//        System.out.println(SonClass.age);

//        通过数组定义类引用，不会触发此类的初始化（前提是 不能往数组中放数据）
//        ParentClass[] parentClasses = new ParentClass[10];

//        调用ClassLoader类的loadClass()方法加载一个类，
//        并不是对类的主动使用，不会导致类的初始化
        ClassLoader.getSystemClassLoader().loadClass("com.learn.jvm.jdk8.ParentClass");


        // 会生成类的初始化
//        Class d = Class.forName("com.learn.jvm.jdk8.ParentClass");
    }
}


class SonClass extends ParentClass{
}

class ParentClass{
//    public static int age = 20;

    public String name = "yds";
    static {
        System.out.println("ParentClass");
    }
}