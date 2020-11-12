package com.learn.dataStructure.D5Search;

import java.math.BigDecimal;

/**
 * @author yds
 * @title: S3InsertSearch
 * @description: TODO
 * @date 2020/11/12 10:40
 */
public class S3InsertSearch {
    public static void main(String[] args) {
        int[] arrray = {1,3,5,7,9,34,99999,99999999,99999999,99999999};
        int target = 99999999;
        int targetIndex = insertSearch(target, arrray, 0, arrray.length - 1);
        System.out.println("查找值：" + target  + "，下标：" + targetIndex);
    }

    private static int insertSearch(int target, int[] array, int left, int right) {
        if(left > right || target < array[0] || target > array[right]){
            return -1;
        }

        // left + (right - left) *(target - array[left]) / (array[right] - array[left]);
        // 避免出现 大于Integer 的最大值 特殊处理而已 公式不变
        BigDecimal midBigDecimal = new BigDecimal(left).add(
                new BigDecimal(right - left)
                         .multiply(new BigDecimal(target - array[left]))
                         .divideToIntegralValue(new BigDecimal((array[right] - array[left]))));
        int mid = midBigDecimal.intValue();
        if(array[mid] == target){
            return mid;
        }

        if(target > array[mid]) {
            return insertSearch(target, array, mid + 1, right);
        }else {
            return insertSearch(target, array, left, mid - 1);
        }
    }
}
