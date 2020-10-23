package com.yds.test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yds
 * @title: HashMapTest
 * @description: TODO
 * @date 2020/5/1414:07
 */
public class HashMapTest {
    public static void main(String[] args) {
        int number = 10;
        //原始数二进制
        System.out.println("原始数二进制=" + Integer.toBinaryString(number));

        number = number << 1;
        //左移一位
        System.out.println("<< 1=" + Integer.toBinaryString(number));

        number = number >> 1;
        //右移一位
        System.out.println(">> 1=" + Integer.toBinaryString(number));

        number = number >>> 1;
        //右移一位
        int i = "fsfsfdsfsfsdfsdfdsfdsfsd".hashCode();
        System.out.println("key =" + Integer.toBinaryString(i));
        System.out.println("移位操作 =" + Integer.toBinaryString(i >>> 16));
        System.out.println("^操作 =" + Integer.toBinaryString(i ^ i >>> 16));
        System.out.println("^操作 =" + (i ^ i >>> 16));
        System.out.println("&操作 =" + ((i ^ i >>> 16) & 1));

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>(32);
        System.out.println(objectObjectHashMap.toString());
        objectObjectHashMap.put("dddd","ddd");
        objectObjectHashMap.get("dddd");
        int n = 18 - 1;
        n |= n >>> 1;
        System.out.println(n);
        n |= n >>> 2;
        System.out.println(n);
        n |= n >>> 4;
        System.out.println(n);
        n |= n >>> 8;
        System.out.println(n);
        n |= n >>> 16;

//        System.out.println(Math.sqrt((double) n));
        System.out.println("-----:" + (n+1));

//
//        10101000101100101100110001011011
//                        1010100010110010
//        10101000101100100110010011101001

        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
        objectObjectConcurrentHashMap.put("dd","ddd");
    }


    class Person{

        @Override
        public int hashCode() {

            return 0000;
        }
    }
}
