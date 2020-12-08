package com.learn.dataStructure.D4Sort;

import java.util.Arrays;

/**
 * @author yds
 * @title: Test
 * @description: TODO
 * @date 2020/11/17 17:31
 */
public class Test {
    static int[] array = {0,0,0,0,1, 2, 3, 4, 5, 6, 7, 8, 0};

    public static void main(String[] args) {
//        insertSorting(array);
        shellSorting(array);

    }

    private static void shellSorting(int[] array) {
        // 将数组按照步长进行分组
        // 步长选取的方式为：数组长度/2；直至 步长/2 == 0 结束
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int j = step; j < array.length; j++) { // 当前元素
                int k = j - step; // 前一个元素
                while (k >= 0) {
                    if (array[k + step] < array[k]) {
                        swap(array, k, k + step);
                    }
                    k -= step;
                }
            }
        }
        System.out.println("希尔排序：" + Arrays.toString(array));
    }

    private static void insertSorting(int[] array) {
        // 将数组分为有序组和无序组
        // 将无序组待排序的数据放到有序组合适的位置
        for (int i = 1; i < array.length; i++) {
            int toIndex = i - 1;
            int toValue = array[i];

            while (toIndex >= 0 && toValue < array[toIndex]) {
                array[toIndex + 1] = array[toIndex];
                toIndex--;
            }
            if (toIndex != i - 1) {
                array[toIndex + 1] = toValue;
            }
        }
        System.out.println("插入排序：" + Arrays.toString(array));

    }


    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
