package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author yds
 * @title: InsertionSort
 * @description: 插入排序包含
 * 1.直接插入排序
 * 它的工作原理：把n个元素看成一个有序表和一个无序表
 * 通过构建有序表，对于未排序数据，在已排序表中从后向前扫描，找到相应位置并插入。
 * <p>
 * <p>
 * 2.希尔排序
 * @date 2020/8/20 10:29
 */
public class S1InsertionSort extends BaseSort {

    public static void main(String[] args) {
        int[] array = {10,7,1,3,9,4};
//        10,7,1,3,9,4
//        7,10,1,3,9,4
//        1,7,10,3,9,4
//        1,3,7,10,9,4
//        1,3,7,9,10,4
//        1,3,4,7,9,10
        printlnArray("排序前",array);
        LocalDateTime begin = LocalDateTime.now();
        insertSorting(array);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后",array);
    }


    /**
     * 插入排序 n^2
     * @param array
     */
    private static void insertSorting(int[] array) {

//        7,10,1,3,9,4
//        1< 10 ===7,10,10,3,9,4
//        1< 7 ===7,7,10,3,9,4
        for (int i = 1; i < array.length; i++) {
            int toInsertValue = array[i];
            int toInsertIndex = i - 1;
            while (toInsertIndex >= 0 && toInsertValue < array[toInsertIndex]){
                array[toInsertIndex + 1] = array[toInsertIndex];
                toInsertIndex--;
            }
            array[toInsertIndex + 1] = toInsertValue;
        }
    }
}
