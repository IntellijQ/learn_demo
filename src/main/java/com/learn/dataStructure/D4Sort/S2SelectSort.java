package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author yds
 * @title: ExchangeSort
 * @description: 选择排序包含
 * 1.简单选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 * <p>
 * <p>
 * 2.堆排序
 * @date 2020/8/21 15:46
 */
public class S2SelectSort extends BaseSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 1, 3, 9, 4,0,45,90,1234,343,56,123,101,54,321,444,5555,1,98,87,6,43,23,456,789,9876,56,35,246,8760,2386,2358,109,5603};
//        1,7,10,3,9,4
//        1,3,10,7,9,4
//        1,3,4,7,9,10
//        1,3,4,7,9,10
//        1,3,4,7,9,10
//        printlnArray("排序前", array);
        LocalDateTime begin = LocalDateTime.now();
//        selectSorting(array);
        heapSorting(array);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后", array);
    }

    /**
     * 选择排序 n^2
     *
     * @param array
     */
    private static void selectSorting(int[] array) {
        int minIdex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            minIdex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdex]) {
                    minIdex = j;
                }
            }
            swap(array, i, minIdex);
        }
    }


    private static void heapSorting(int[] array) {
        // 构建大顶堆：根节点 大于 左右节点
        int nodeNum = array.length / 2 - 1;
        for (int currentIndex = nodeNum; currentIndex >= 0; currentIndex--) {
            adjustHeap(array, array.length, currentIndex);
        }
//        System.out.println("大顶堆：" + Arrays.toString(array));

        for (int i = array.length - 1; i > 0; i--) {
            // 排序
            swap(array, 0, i);
            adjustHeap(array, i, 0);
        }
    }

    private static void adjustHeap(int[] array, int length, int currentIndex) {
        int leftIndex = 2 * currentIndex + 1;
        while (leftIndex < length) {
            int check = leftIndex;
            int rightIndex = leftIndex + 1;
            // 比较左右两边值
            if (rightIndex < length && array[leftIndex] < array[rightIndex]) {
                check = rightIndex;
            }
            // 比较当前节点和左右节点 并交换
            if (array[currentIndex] < array[check]) {
                swap(array, currentIndex, check);
            }
            currentIndex = check;
            leftIndex = 2 * currentIndex + 1;
        }
    }


    /**
     * 构建大顶堆：根节点 大于 左右节点
     *
     * @param array
     */
    private static void createHeap(int[] array, int length, boolean maxHeap) {
        int nodeNum = length / 2 - 1;
        for (int i = nodeNum; i >= 0; i--) {
            int currentIndex = i;
            int leftIndex = 2 * currentIndex + 1;

            while (leftIndex < length) {
                int check = leftIndex;
                int rightIndex = leftIndex + 1;
                if (maxHeap) { // 最大顶堆
                    // 比较左右两边值
                    if (rightIndex < length && array[leftIndex] < array[rightIndex]) {
                        check = rightIndex;
                    }

                    // 比较当前节点和左右节点 并交换
                    if (array[currentIndex] < array[check]) {
                        swap(array, currentIndex, check);
                    }
                } else {// 最小顶堆
                    // 比较左右两边值
                    if (rightIndex < length && array[leftIndex] > array[rightIndex]) {
                        check = rightIndex;
                    }

                    // 比较当前节点和左右节点 并交换
                    if (array[currentIndex] > array[check]) {
                        swap(array, currentIndex, check);
                    }
                }

                currentIndex = leftIndex;
                leftIndex = 2 * currentIndex + 1;
            }

        }
        System.out.println((maxHeap ? "大顶堆：" : "小顶堆：") + Arrays.toString(array));
    }
}
