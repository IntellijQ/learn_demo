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
 * 缩小增量排序
 * 它的工作原理：把n个元素按下标进行增量m的分组，对每组使用直接插入排序；
 * 随着增量m的减少，每组包含的元素越来越多，当m=1时，算法终止
 * @date 2020/8/20 10:29
 */
public class S1InsertionSort extends BaseSort {

    public static void main(String[] args) {
//        int[] array = {10, 7, 1, 3, 9, 4, 0 , 9, 8, 1,-9};
//        10,7,1,3,9,4
//        7,10,1,3,9,4
//        1,7,10,3,9,4
//        1,3,7,10,9,4
//        1,3,7,9,10,4
//        1,3,4,7,9,10
        printlnArray("排序前", array);
        LocalDateTime begin = LocalDateTime.now();
//        insertSorting(array);
//        shellSortingChange(array);
        shellSortingInsert(array);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后", array);
    }

    /**
     * 希尔排序--交换方式
     * 缩短步长方式
     *
     * @param array
     */
    private static void shellSortingChange(int[] array) {
        // 10/2=5 步长为5的组成 一组数据
        // 5/2=2
        // 2/2=1
        // 1/2=0
        // 步长数
        for (int stepCount = array.length / 2; stepCount > 0; stepCount /= 2) {
            for (int currentIndex = stepCount; currentIndex < array.length; currentIndex++) {// 当前数据
                for (int j = currentIndex - stepCount; j >= 0; j -= stepCount) { // 同一分组内的数据
                    if (array[j + stepCount] < array[j]) {
                        swap(array, j, j+stepCount);
                    }
                }
            }
        }
    }

    /**
     * 希尔排序--插入方式
     * 缩短步长方式
     *
     * @param array
     */
    private static void shellSortingInsert(int[] array) {
        // 10/2=5 步长为5的组成 一组数据
        // 5/2=2
        // 2/2=1
        // 1/2=0
        // 步长数
        for (int stepCount = array.length / 2; stepCount > 0; stepCount /= 2) {
            for (int currentIndex = stepCount; currentIndex < array.length; currentIndex++) { // 当前数据
                int toInserValue = array[currentIndex];
                int toInsertIndex = currentIndex - stepCount;
                while (toInsertIndex >= 0 && toInserValue < array[toInsertIndex]) { // 同一分组内数据
                    array[toInsertIndex + stepCount] = array[toInsertIndex];
                    toInsertIndex -= stepCount;
                }
                array[toInsertIndex + stepCount] = toInserValue;
            }
        }
    }

    /**
     * 插入排序 n^2
     *
     * @param array
     */
    private static void insertSorting(int[] array) {

//        7,10,1,3,9,4
//        1< 10 ===7,10,10,3,9,4
//        1< 7 ===7,7,10,3,9,4
        for (int i = 1; i < array.length; i++) {
            int toInsertValue = array[i];
            int toInsertIndex = i - 1;
            while (toInsertIndex >= 0 && toInsertValue < array[toInsertIndex]) {
                array[toInsertIndex + 1] = array[toInsertIndex];
                toInsertIndex--;
            }
            array[toInsertIndex + 1] = toInsertValue;
        }
    }
}
