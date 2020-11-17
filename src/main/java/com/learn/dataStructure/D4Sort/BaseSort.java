package com.learn.dataStructure.D4Sort;

import java.util.Arrays;

/**
 * @author yds
 * @title: BaseSort
 * @description: TODO
 * @date 2020/10/30 18:20
 */
public class BaseSort {
    static int max = 1000000;
    static int[] array = new int[max];

    static {
        for (int i = 0; i < max; i++) {
            array[i] = (int) (Math.random() * 8000000);
        }
    }



    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * 打印数组
     *
     * @param desc
     * @param array
     */
    public static void printlnArray(String desc, int[] array) {
        if(array.length > 100){
            return;
        }
        System.out.print(desc + ":");
        System.out.printf(Arrays.toString(array));
        System.out.println();
    }
}
