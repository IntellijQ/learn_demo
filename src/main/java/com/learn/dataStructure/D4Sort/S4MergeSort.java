package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author yds
 * @title: MergeSort
 * @description: 归并算法 O(nlogn)
 * 1.分 将长度为n的数组，拆分成 n个长度为1的有序数组
 * 2.治 将n个数组，合并
 * @date 2020/8/25 16:21
 */
public class S4MergeSort extends BaseSort {

    public static void main(String[] args) {
        int[] array = {8, 1, 7, 9, 1, 2, 3, 6};
        int[] temp = new int[array.length];
        printlnArray("排序前", array);
        LocalDateTime begin = LocalDateTime.now();
        mergeSorting(array, 0, array.length - 1, temp);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后", array);
    }

    private static void mergeSorting(int[] array, int left, int right, int[] temp) {
        System.out.println("入栈=(" + left + "," + right + ")");
        if (left < right) {
            int mid = (left + right ) /2;
            mergeSorting(array,left, mid,temp);
            mergeSorting(array,mid + 1, right,temp);
            // 拆分后合并 即出栈
            merge(array, left, right, mid, temp);
        }

    }

    private static void merge(int[] array, int left, int right, int mid, int[] temp) {
        System.out.println("出栈=(" + (mid+1) + "," + right + ")");
        System.out.println("出栈=(" + left + "," + mid + ")");
        int i = left;
        int j = mid + 1;
        int tei = 0;

        // 1.比较
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[tei] = array[i];
                i++;
            } else {
                temp[tei] = array[j];
                j++;
            }
            tei++;
        }

        // 2.填充剩余
        while (i <= mid) {
            temp[tei] = array[i];
            i++;
            tei++;
        }
        while (j <= right) {
            temp[tei] = array[j];
            j++;
            tei++;
        }

        // 3.复制到原数组
        tei = 0;
        int ci = left;
        while (ci <= right){
            array[ci] = temp[tei];
            ci++;
            tei++;
        }
    }
}
