package com.learn.dataStructure.D5Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yds
 * @title: S2BinarySearch
 * @description: 二分查找法
 * @date 2020/11/9 16:10
 */
public class S2BinarySearch {
    public static void main(String[] args) {
        // 从小到大排序
        int[] array = {0, 1, 2, 3, 3, 3, 6, 7};
        int target = 9;
        List<Integer> integers = binarySearch(target, array, 0, array.length - 1);
        System.out.println("查找值：" + target  + "，下标：" + integers.toString());
    }

    private static List<Integer> binarySearch(int target, int[] array, int left, int right) {
        if(left > right || target < array[0] || target > array[right]){
            throw new RuntimeException("查找值：" + target + "，不存在");
        }

        List<Integer> arrayList = new ArrayList<>();
        int mid = (left + right) / 2;
        // 在中间
        if (target == array[mid]) {
            int temp = mid - 1;
            // 找到目标值后，继续向左
            while (temp >= 0 && array[temp] == target) {
                arrayList.add(temp);
                temp--;

            }

            temp = mid + 1;
            // 找到目标值后，继续向向右
            while (temp <= right && array[temp] == target){
                arrayList.add(temp);
                temp++;
            }
            arrayList.add(mid);
            return arrayList;
        }

        if (target > array[mid]) {// 在右边
            return binarySearch(target, array, mid + 1, right);
        } else {// 在左边
            return binarySearch(target, array, left, mid);
        }
    }
}
