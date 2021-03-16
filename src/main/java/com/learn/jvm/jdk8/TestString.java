package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestString
 * @description: TODO
 * @date 2020/12/29 16:31
 */
public class TestString {

    public static void main(String[] args) {
        TestString testString = new TestString();
//        String str = "榕溪";
//        char[] c = {'a','b','c'};
//        testString.change(str, c);
//        System.out.println(str);
//        System.out.println(c);
//
//        str.intern();

//        testString.test2();
    }

    public void change(String str, char[] c){
        str = "新玖富";
        c[0] = 'T';
    }


    public void test(){
        String s1 = "a" + "b" + "c";
        String s2 = "abc";
        System.out.println(s1 == s2);
    }

    public void test2(){
        String s1 = "a";
        String s2 = "n";
        String s3 = "an";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
//        String string = new StringBuilder("a").append("n").toString();
//        System.out.println(s3 == string);
    }
}
