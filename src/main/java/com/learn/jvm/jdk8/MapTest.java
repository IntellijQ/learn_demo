package com.learn.jvm.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yds
 * @title: MapTest
 * @description: TODO
 * @date 2021/3/8 13:17
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(11, "11");
        map1.put(22, "22");
        long key1 = 11;
        System.out.println(map1.get(key1));  // null

        Map<Long, String> map2 = new HashMap<Long, String>();
        map2.put(11L, "11");
        map2.put(22L, "22");
        int key2 = 11;
        System.out.println(map2.get(key2));  // 11




        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);//true
        System.out.println(Objects.equals(c, d));//true
        System.out.println(Objects.equals(c, g));//false

        System.out.println(e == f);//false
        System.out.println(c == (a+b));//true
        System.out.println(c.equals(a+b));//true
        System.out.println(g == (a+b));//true
        System.out.println(g.equals(a+b));//false
    }


    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
