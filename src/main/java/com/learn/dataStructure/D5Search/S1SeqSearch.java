package com.learn.dataStructure.D5Search;

/**
 * @author yds
 * @title: S2BinarySearch
 * @description: 线性查找（顺序查找）
 * @date 2020/11/9 16:10
 */
public class S1SeqSearch {
    public static void main(String[] args) {
        int[] array = {2,4,1,6,10,53};
        int target = 2;
        int result= seqSearch(target,array);
        System.out.println("查找值：" + target + (result >=0 ? "，在下标" + result+ "处" : "，不存在"));
    }

    private static int seqSearch(int target, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(target == array[i]){
                return i;
            }
        }
        return -1;
    }
}
