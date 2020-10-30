package com.learn.dataStructure.D4Sort;

/**
 * @author yds
 * @title: InsertionSort
 * @description: 插入排序
 * @date 2020/8/20 10:29
 */
public class S1InsertionSort {
//    public static int[] param = {45,2,78,34,12,90,76,39,44,56,34,89,120,498,333,100,3};
    public static int[] param = {2,34,55,100,40};
    public static void main(String[] args) {
        binaryInsertionSort(param);
    }


    /**
     * //34
     * lastMaxIndx=2
     * hasSortIndex=2
     * current=34
     * param[hasSortIndex]=78
     * 2 45 78 34 hasSortIndex=2
     * 2 45 78 78 param[2] = 78 param[3] = param[2] = 78 hasSortIndex=1
     * 2 45 45 78 param[1] = 45 param[2] = param[1] = 45 hasSortIndex=0
     * 2 34 45 78 param[0] = 2 param[1] = current = 34 hasSortIndex=-1
     * 直接插入排序
     * @author yds
     * @date 2020/8/20 17:51
     * @param param
     * @return void
    */
//    时间复杂度为O(n2)
//    直接插入排序（straight insertion sort）是一种比较简单的排序方法，
//    它的基本思想是，依次将记录序列中的每一个记录插入到有序段中，使有序段的长度不断地扩大。
//    算法实现思路是，先将待排序记录序列中的第一个记录作为一个有序段，
//    将记录序列中的第二个记录插入到上述有序段中形成的由两个记录组成的有序段，
//    再将记录序列中的第三个记录插入到这个有序段中，
//    形成由三个记录组成的有序段，……，其余类推，
//    直到所有记录都插入到有序段中为止。
//    一共需要经过n-1趟就可将初始序列的n个记录重新排列成按关键码值大小排列的有序序列。
    public static void straightInsertionSort(int[] param){
        for(int i = 1; i < param.length; i ++){
            int lastMaxIndx = i - 1;
            int lastMax = param[lastMaxIndx];
            int current = param[i];//当前待插入的值
            if(current >= lastMax){
                continue;
            }

            int hasSortIndex = lastMaxIndx;
            while (hasSortIndex >= 0 && current < param[hasSortIndex]){
                param[hasSortIndex + 1] = param[hasSortIndex];
                hasSortIndex--;
            }
            param[hasSortIndex+1] = current;//插入正确的位置
        }
    }


    /**
     * 45,2,78,34,12,90,76,39,44,56,34,89,120,498,333,100,3
     * 2 34 45 78 60
     * 二分插入排序
     * @author yds
     * @date 2020/8/25 10:38
     * @param param
     * @return void
    */
//    时间复杂度为O(n2)
//    由于插入排序的基本思想是将待插入的新记录插入到已排序的有序表中，
//    因此可在查找插入位置时采用折半查找的方法
    public static void binaryInsertionSort(int[] param){
        for (int i = 1; i < param.length; i++) {
            int lastMaxIndx = i - 1;
            int lastMax = param[lastMaxIndx];
            int current = param[i];//当前待插入的值
            if(current >= lastMax){
                continue;
            }

            int low = 0;
            int high = lastMaxIndx;
            while(low <= high){
                int middle = (low + high)/2;
                if(current < param[middle]){
                    //插入低区域
                    high = middle - 1;
                }else {
                    //插入高区域
                    low = middle + 1;
                }
            }

            System.out.println("high=" + high);
            for(int j = lastMaxIndx;j > high; j--){
                param[j + 1] = param[j];
            }
            System.out.println("二分插入： " + (high + 1));
            param[high+1] = current;//插入正确的位置
        }
    }
}
