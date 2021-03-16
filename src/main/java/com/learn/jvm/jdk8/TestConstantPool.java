package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestConstantPool
 * @description: TODO
 * @date 2020/12/21 11:22
 */
public class TestConstantPool {
//    private int d;
    private int a1 = 11;
    private static int a2 = 12;
    private final int a3 = 13;
    private static final int a4 = 14;

    public static void main(String[] args) {
        while (true){
            String dd = "java";
            String intern = dd.intern();
            System.out.println(dd == intern);


            M m = null;
            m.getAA();
            System.out.println(m.age);
            System.out.println(a4);
        }


    }
//    static {
//        a1 = 100;
//        a1 = a1 + 5;
//        a1 = a1 + 777;
//    }
//    private int dd = 123;
//    private int dd3= 1323;
//
//
//    public static void main(String[] args) {
//        System.out.println(a1);
//    }
}

class M{
    public static int age = 100;
    public static void getAA(){
        final int dd = 10;
        System.out.println("getAA()");
    }
}
