package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;

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
        int[] array = {10,7,1,3,9,4};
//        10,7,1,3,9,4
//        7,10,1,3,9,4
//        7,1,10,3,9,4
//        7,1,3,10,9,4
//        7,1,3,9,10,4
//        7,1,3,9,4,10
//
//        1,7,3,9,4,10
//        1,3,7,9,4,10
//        1,3,7,9,4,10
//        1,3,7,4,9,10
//
//        1,3,7,4,9,10
//        1,3,7,4,9,10
//        1,3,4,7,9,10
//
//        1,3,4,7,9,10
//        1,3,4,7,9,10
//
//        1,3,4,7,9,10
        printlnArray("排序前", array);
        LocalDateTime begin = LocalDateTime.now();
        bulleSorting(array);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后", array);
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
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
//            System.out.println("第" + (i + 1) + "趟，排序选择的最大值：" + array[array.length - 1 - i]);

            // 优化部分 如果一趟循环下来，没有任何交换 则直接跳出
            if (!isExchange) {
                break;
            }
            // 一趟下来，需要还原 标识位
            isExchange = false;
        }

    }
}
