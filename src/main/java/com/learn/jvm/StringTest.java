package com.learn.jvm;

/**
 * @author yds
 * @title: StringTest
 * @description: TODO
 * @date 2020/5/1518:06
 */
public class StringTest {
    public static void main(String[] args) {
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        //sun.misc.Version
//        String str2 = new StringBuilder("Ja").append("va").toString();
//
//        System.out.println(str1.intern() == str1);//因为之前没有所以创建的引用和intern()返回的引用相同
//        System.out.println(str2.intern() == str2);//"java在StringBuilder()之前已经出现过",所以intern()返回的引用与新创建的引用不是同一个
//
//        String str3 = "java";
//        String str4 = new String("java");
//        System.out.println(str3 == str4);

        String tt1 = "天下第一";
        String tt2 = new String("天下第一");
        String tt3 = tt2.intern();
        System.out.println(tt1 == tt2);//false "天下第一"存在常量池中，归输入堆，tt2指向new String()的一个引用，故不相等
        System.out.println(tt2 == tt3);//false tt3 会首先检查常量池中，是否有相等字符常的常量，如果有，则指向该对象 （1.6以后）
        System.out.println(tt1 == tt3);//true

//        System.out.println(ClassLayout.parseInstance(d).toPrintable());
//        System.out.println(ClassLayout.parseInstance(d).toPrintable());

//        System.out.println(String.format("sizeof(new A):%s", ClassLayout.parseInstance(d).instanceSize()));

//        System.out.println(GraphLayout.parseInstance(d).toPrintable());
    }
}
