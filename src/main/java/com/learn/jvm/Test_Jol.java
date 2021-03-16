package com.learn.jvm;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * @author yds
 * @title: Test_Jol
 * @description: TODO
 * @date 2020/12/16 14:22
 */
public class Test_Jol {
    public static void main(String[] args) throws InterruptedException {
        // 默认开启普通指针对象压缩 +UseCompressedOops
        // 默认开启classPointer指针压缩 +UseCompressedClassPointers
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        System.out.println(String.format("sizeof(new Object):%s", ClassLayout.parseInstance(o).instanceSize()));
//        System.out.println();


        //-XX:-UseCompressedClassPointers -XX:-UseCompressedOops
        //mk 8
        //classpoint 8
        //s = 8
        //int 4
        //pending 4
        //32

        //-XX:+UseCompressedClassPointers -XX:+UseCompressedOops
        //mk 8
        //classpoint 4
        //s = 4
        //int 4
        //pending 4
        //
        Thread.sleep(5000);
        T obj = new T();
        //打印对象内存布局
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
//        //打印对象的所有相关内存占用
//        System.out.println(GraphLayout.parseInstance(obj).toPrintable());
//        //打印对象的所有内存结果并统计
//        System.out.println(GraphLayout.parseInstance(obj).toFootprint());
//        System.out.println(obj.hashCode());// 如果计算过对象的hashcode，则对象无法进入偏向状态
        synchronized(obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }



//        System.out.println();
//        String s = new String();
//        System.out.println(ClassLayout.parseInstance(s).toPrintable());
//        //打印对象的所有相关内存占用
//        System.out.println(GraphLayout.parseInstance(s).toPrintable());
//        //打印对象的所有内存结果并统计
//        System.out.println(GraphLayout.parseInstance(s).toFootprint());
    }
}