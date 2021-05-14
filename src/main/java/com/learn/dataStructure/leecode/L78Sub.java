package com.learn.dataStructure.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yds
 * @title: L78Sub
 * @description: 子集
 * @date 2020/12/11 18:44
 */
public class L78Sub {
    public static void main(String[] args) {

    }



    // {1,2,3}
    // {1}
    // {1,2}
    // {1,2,3}
    // {1,3}
    // {2}
    // {2,3}

    // {3}
    public void sub(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<Integer> sub = new ArrayList<>();
            findNext(nums, i + 1);
        }
    }

    public void findNext(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++) {
            findNext(nums, i);
        }
    }
}
