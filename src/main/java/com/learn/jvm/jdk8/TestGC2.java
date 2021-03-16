package com.learn.jvm.jdk8;

/**
 * @author yds
 * @title: TestGC2
 * @description: 模拟生成3次yonggc 然后 进行fullgc 不可内存溢出
 * @date 2020/12/25 14:55
 */
public class TestGC2 {

    private final static int MB_1 = 1024 * 1024;
    public static void main(String[] args) {
        // 垃圾收集器 UseSerialGC
        // 不可扩展
        // 堆内存为20m
        // 我这里设置的新生代为10m
        // 新生代比例 8：1  因为虚拟机启动过程中会占用一部分空间，eden实际可用的只有4m-5m
        // 设置-XX:MaxTenuringTheshold=1

        byte[] bytes = new byte[MB_1 * 11];
//        byte[] bytes2 = new byte[MB_1 * 3];// eden=4
//        byte[] bytes3 = new byte[MB_1];//young eden=0,s0=1,old=3 ==>eden=1,s0=1,old=3
//        byte[] bytes4 = new byte[MB_1*5];//young eden=0,s0=1,s1=0,old=4 ==> eden=4,s0=1,s1=0,old=4
//        byte[] bytes5 = new byte[MB_1 * 1];
    }
}
