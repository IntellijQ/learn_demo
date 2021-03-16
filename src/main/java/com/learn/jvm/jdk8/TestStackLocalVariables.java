package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestStackLocalVariables
 * @description: 虚拟机栈--局部变量表
 * @date 2020/12/18 11:24
 */
public class TestStackLocalVariables {

    public static void main(String[] args) {
        Object o = new Object();
        int b = 7;
        test1();
    }

    public static void test1(){
        // 静态方法中 不能使用this，因为在局部变量表中 没有this的槽
//        this.clone();
        int a = 7;
    }


    public void hello(){
        this.equals("dd");

        double aa = 9d;
        if(1 == 2){
            int a = 3;
        }
        {
            int ddddd = 9;
        }
        int b = 3;
        long c = 3l;
        char d = 'l';

        Double da = 12d;
        Long la = 23l;

        String dd = "dd";
        int qw = 4;
        if(2 == 4){
            int ddd = 9;
        }
    }
}
