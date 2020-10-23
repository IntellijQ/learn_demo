package com.learn.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;

/**
 * @author yds
 * @title: JolTest
 * @description: TODO
 * @date 2020/5/1911:09
 */
public class JolTest {
    public static void main(String[] args) {

//        A obj = new A();
        HashMap<Long, Long> obj = new HashMap<>();
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println(String.format("sizeof(new A):%s", ClassLayout.parseInstance(obj).instanceSize()));
        //查看对象外部信息
//        System.out.println(GraphLayout.parseInstance(obj).toPrintable());
//
//        synchronized (obj){
//            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
//        }

//        OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//        0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//        4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//        8     4        (object header)                           00 1c d0 1b (00000000 00011100 11010000 00011011) (466623488)
//        12     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)

//        OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//        0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//        4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//        8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
//        12     4        (loss due to the next object alignment)


    }


//    OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//            4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//            8     4        (object header)                           a0 35 ce 1c (10100000 00110101 11001110 00011100) (483276192)
//            12     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//            16     4    int A.a                                       0
//            20     4        (loss due to the next object alignment)
//

//    OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
//      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
//            4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
//            8     4        (object header)                           43 c1 00 f8 (01000011 11000001 00000000 11111000) (-134168253)
//            12     4    int A.a                                       0
    static class A {
//        Integer a=0;

    }
}
