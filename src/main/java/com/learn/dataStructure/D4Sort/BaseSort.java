package com.learn.dataStructure.D4Sort;

import java.util.Arrays;

/**
 * @author yds
 * @title: BaseSort
 * @description: TODO
 * @date 2020/10/30 18:20
 */
public class BaseSort {
    static int max = 10;
    static int[] array = new int[max];

    static {
        for (int i = 0; i < max; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
    }

    /**
     * 打印数组
     *
     * @param desc
     * @param array
     */
    public static void printlnArray(String desc, int[] array) {
        System.out.print(desc + ":");
        Arrays.stream(array).forEach(item -> System.out.printf(item + " "));
        System.out.println();
    }
}
