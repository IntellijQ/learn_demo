package com.learn.dataStructure.D4Sort;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yds
 * @title: S5RadixSort
 * @description: 基数排序
 * 空间换时间 正负数都可进行
 * @date 2020/11/6 11:24
 */
public class S5RadixSort extends BaseSort {
    public static void main(String[] args) {
        int[] array = {-81, -1000006, 17, 32, -52, -1, -5, 9, 19, 24, 100000002};
        printlnArray("排序前", array);
        LocalDateTime begin = LocalDateTime.now();
        radixSorting(array);
        LocalDateTime end = LocalDateTime.now();
        Duration between = Duration.between(begin, end);
        System.out.println("耗时：" + between.toMillis() + "毫秒 = " + between.toMillis() / 1000 + "秒");
        printlnArray("排序后", array);
    }

    private static void radixSorting(int[] array) {
        int maxv = 0;
        int minv = 0;
        // 查找最大、最小值
        for (int i = 0; i < array.length; i++) {
            maxv = Math.max(maxv, array[i]);
            minv = Math.min(minv, array[i]);
        }

        // 处理负数
        if (minv < 0) {
            for (int i = 0; i < array.length; i++) {
                // 减去最小负值，保证数据为非负数
                array[i] -= minv;
            }
            maxv -= minv; //!max也要处理！
        }

        // 最大数字长度
        int maxUnit = (maxv + "").length();

        // 0-9 十个数字桶 存放的数据集合
        Map<Integer, List<Integer>> bucketItemMap = new HashMap<>();

        for (int currentUnit = 0; currentUnit < maxUnit; currentUnit++) {
            // 按照当前位值，放入桶中
            for (int i = 0; i < array.length; i++) {
                int unit = (int) Math.pow(10, currentUnit);
                int num = array[i] / unit % 10;
                if (bucketItemMap.get(num) == null) {
                    ArrayList<Integer> items = new ArrayList<>();
                    items.add(array[i]);
                    bucketItemMap.put(num, items);
                } else {
                    bucketItemMap.get(num).add(array[i]);
                }
            }

            // 按照当前位值，从桶中取出，赋值到原数组
            int i = 0;
            for (Map.Entry<Integer, List<Integer>> entry : bucketItemMap.entrySet()) {
                List<Integer> v = entry.getValue();
                for (Integer item : v) {
                    array[i] = item;
                    i++;
                }
            }

            // 重置桶数据
            bucketItemMap = new HashMap<>();
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] + minv;
        }
    }
}
