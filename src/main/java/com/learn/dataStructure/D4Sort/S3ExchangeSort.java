package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author yds
 * @title: ExchangeSort
 * @description: 交换排序包含
 * 1.冒泡排序-bulle sorting
 * 通过对未排序元素 从前向后看，依次比较相邻元素的值，
 * 若发现逆序则交换，使值较大的元素逐渐从前向后移动
 * 2.快速排序
 * @date 2020/8/21 15:46
 */
public class S3ExchangeSort extends BaseSort {

    public static void main(String[] args) {
        int[] array = {9, 1, 5, 3, 5, 6, 6, 7, 8, 9};
        printlnArray("排序前", array);
        LocalDateTime begin = LocalDateTime.now();
//        bulleSorting(array);
//        quickSortingForBeginOne(array, 0, array.length - 1);
//        quickSortingForBeginLeftRight(array, 0, array.length - 1);
        quickSortingMidBeginLeftRight(array, 0, array.length - 1);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后", array);
    }

    /**
     * 快速排序--取中间值-使用左右指针
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSortingMidBeginLeftRight(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        // 分区
        int pivotv = array[(left + right) / 2];
        int le = left - 1;
        int ri = right + 1;
        while (true) {
            while (array[++le] < pivotv) ;
            while (array[--ri] > pivotv) ;
            if (le >= ri) break;
            int temp = array[le];
            array[le] = array[ri];
            array[ri] = temp;
        }

//        9, 1, 5, 3, 5, 6, 6, 7, 8, 9
//        5, 1, 5, 3, 9, 6, 6, 7, 8, 9
//        5, 1, 3, 5, 9, 6, 6, 7, 8, 9
        System.out.println(Arrays.toString(array));
//        System.out.println("le=" + le + ",ri=" + ri);
        System.out.println("基准数:" + pivotv + ",左边=（" + left + "," + (le - 1 ) + "） 右边=（ " + (ri + 1) + "," + right + "）");
        // 左排序
        quickSortingMidBeginLeftRight(array, left, le - 1);
        // 右排序
        quickSortingMidBeginLeftRight(array, ri + 1, right);
    }

    /**
     * 快速排序--使用左右指针
     *
     * @param array
     * @param left
     * @param right
     */
    private static void quickSortingForBeginLeftRight(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        // 基准值设置
        int pivot = left;
        int pivotv = array[pivot];

        // 左右哨兵指针
        int le = left;
        int ri = right;

        while (le < ri) {
            // 因为基准值设置在最左边，所有需要先移动右哨兵指针，直到小于基准值停止
            while (array[ri] >= pivotv && le < ri) {
                ri--;
            }
            // 移动左边哨兵指针，知道大于基金值停止
            while (array[le] <= pivotv && le < ri) {
                le++;
            }

            if (le < ri) {
                //交换左右哨兵值
                swap(array, le, ri);
            }
        }

        // 交换
        if (le != pivot) {
            swap(array, pivot, le);
        }

        // 左排序
        quickSortingForBeginLeftRight(array, left, le - 1);
        // 右排序
        quickSortingForBeginLeftRight(array, le + 1, right);
    }

    /**
     * 快速排序---指针从一端开始
     *
     * @param array
     */
    private static void quickSortingForBeginOne(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        // 基准值设置
        int pivot = left;
        int pivotv = array[pivot];
        // 最大最小分界下标指针
        int pindex = pivot + 1;

        for (int i = pindex + 1; i < right; i++) {
            // 当前值小于基准值则交换
            if (array[i] < pivotv) {
                swap(array, i, pindex);
                pindex++;
            }
        }

        // 基准值放置到对应的分界处
        pindex--;
        swap(array, pivot, pindex);

        // 左排序
        quickSortingForBeginOne(array, left, pindex - 1);
        // 右排序
        quickSortingForBeginOne(array, pindex + 1, right);
    }

    /**
     * 冒泡排序 n^2
     *
     * @param array
     */
    private static void bulleSorting(int[] array) {
        boolean isExchange = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    isExchange = true;
                    swap(array, j, j + 1);
                }
            }
            // 优化部分 如果一趟循环下来，没有任何交换 则直接跳出
            if (!isExchange) {
                break;
            }
            // 一趟下来，需要还原 标识位
            isExchange = false;
        }

    }
}
