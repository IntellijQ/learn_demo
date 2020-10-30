package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author yds
 * @title: ExchangeSort
 * @description: 选择排序包含
 * 1.简单选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕
 *
 *
 * 2.堆排序
 * @date 2020/8/21 15:46
 */
public class S2SelectSort extends BaseSort {

    public static void main(String[] args) {
        printlnArray("排序前",array);
        LocalDateTime begin = LocalDateTime.now();
        selectSorting(array);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后",array);
    }

    private static void selectSorting(int[] array) {
        int minIdex = 0;
        for (int i = 0; i < array.length - 1; i++) { // 最后一趟无需操作（因为前面已经把未排序数据 排序好了）
            minIdex = 0;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] < array[minIdex]){
                    minIdex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIdex];
            array[minIdex] = temp;
        }
    }
}
