package com.sp;
/**
 * @author yds
 * @title: Demo03Logger
 * @description: TODO
 * @date 2021/3/2 17:35
 */
public class Demo03Logger {
    public static void main(String[] args) {
        String msgA = "Hello ";
        String msgB = "World ";
        String msgC = "Java";

        log1(2, () -> {
            System.out.println("log1--Lambada 执行！");
            return msgA + msgB + msgC;
        });

        log2(2, msgA + msgB + msgC);
    }

    private static void log1(int level, MessageBuilder mb) {
        if (level == 1) {
            System.out.println("log1---leve1" + mb.builderMessage());
        }
    }

    private static void log2(int level, String mgs) {
        System.out.println("log2--Lambada 执行！" );
        if (level == 1) {
            System.out.println("log2--leve1" + mgs);
        }
    }
}
