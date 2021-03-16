package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestUseMethod
 * @description: TODO
 * @date 2020/12/22 10:24
 */
public class TestUseMethod {

    public static void hh(Human guy){
        System.out.println("static guy");
    }

    public static void hh(Man guy){
        System.out.println("static man");
    }

    public static void hh(Woman guy){
        System.out.println("static Woman");
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        TestUseMethod testUseMethod = new TestUseMethod();

        testUseMethod.sayHello((Man)man);
        testUseMethod.sayHello(man);
        testUseMethod.sayHello(woman);

        TestUseMethod.hh(man);
        TestUseMethod.hh(woman);
    }

    public void sayHello(Human guy){
        System.out.println("hello guy");
    }

    public void sayHello(Woman guy){
        System.out.println("hello woman");
    }


    public void sayHello(Man guy){
        System.out.println("hello man");
    }

    static class Human{

    }

    static class Woman extends Human{

    }

    static  class Man extends Human{

    }
}
