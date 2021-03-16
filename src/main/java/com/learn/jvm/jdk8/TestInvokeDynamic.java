package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestInvokeDynamic
 * @description: 体验invokeDynamic
 * @date 2020/12/24 16:29
 */
public class TestInvokeDynamic {
    public void test(Func func){
        String ddd = func.go("ddd");
        System.out.println(ddd);
    }

    public static void main(String[] args) {
        TestInvokeDynamic testInvokeDynamic = new TestInvokeDynamic();
//        String qq = "";
//        Func func = s ->{
//            return qq;
//        };
        Func func =null;
        testInvokeDynamic.test(func);
    }
}

interface Func{
    String go(String dd);
}
