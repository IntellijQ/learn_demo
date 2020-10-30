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
        for (int i = 0; i < array.length - 1; i++) { // 最后一趟无需操作（因为前面已经把未排序数据 排序好了）
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
