package com.yds.suanfa;

/**
 * @author yds
 * @title: MergeSort
 * @description: 归并算法 O(nlogn)
 * 1.分 将长度为n的数组，拆分成 n个长度为1的有序数组
 * 2.治 将n个数组，合并
 * @date 2020/8/25 16:21
 */
public class S4MergeSort {
    public static int[] param = {8,4,5,7,1,3,6,2};
    public static void main(String[] args) {
        int[] tempParam = new int[param.length];
        mergeSort(param, 0, param.length-1, tempParam);
    }

    public static void mergeSort(int[] param, int low, int high, int[] tempParam){
        if(low < high){
            int mid = (low + high)/2;
            System.out.println("左分（" + low + "," + mid + "）,右分（" + (mid + 1)+ "," +high + "）");
            mergeSort(param, low, mid, tempParam);
            mergeSort(param, mid + 1, high,tempParam);
            merge2(param, low, mid, high, tempParam);
//            merge(param,low,mid + 1,high,tempParam);
        }
    }

//    0 1 2 3   4 5 6 7
//    low=0
//    high=7
//    mid = 3
//    [4,5,7,8]和[1,2,3,6]
//    leftIndex = 0, rightIndex = 7, 1 2 3
//    leftIndex = 1, rightIndex = 7, 1 2 3 4
//    leftIndex = 2, rightIndex = 7, 1 2 3 4 5
//    leftIndex = 2, rightIndex = end, 1 2 3 4 5 6 7 8
    public static void merge2(int param[], int low, int mid, int high,int[] tempParam){
        System.out.println("合（" + low + "," + high + "）");
        int leftIndex = low;
        int rightIndex = mid + 1;

        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= high){
            if(param[leftIndex] <= param[rightIndex]){
                tempParam[tempIndex++] = param[leftIndex++];
            }else{
                tempParam[tempIndex++] = param[rightIndex++];
            }
        }
        while(leftIndex <= mid){//将左边剩余元素填充进temp中
            tempParam[tempIndex++] = param[leftIndex++];
        }
        while(rightIndex <= high){//将右序列剩余元素填充进temp中
            tempParam[tempIndex++] = param[rightIndex++];
        }

        tempIndex = 0;
        while (low <= high){
           param[low++] = tempParam[tempIndex++];
        }
    }


    public static void merge(int param[], int low, int mid, int high,int[] tempParam){
        int leftSize = mid - low;
        int rightSize = high - mid + 1;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        //分-填充左边数组
        for(int i = low; i < mid; i++){
            left[i - low] = param[i];
        }

        //分-填充右边数组
        for(int i = mid; i<= high; i++){
            right[i - mid] = param[i];
        }

        //治-排序
        int leftPoint = 0;
        int rightPoint = 0;
        int inserPoint = 0;
        while(leftPoint < leftSize && rightPoint < rightSize){
            int temp = 0;
            //从小到大
            if(left[leftPoint] < right[rightPoint]){
                temp = left[leftPoint];
                leftPoint++;
            }else {
                temp = right[rightPoint];
                rightPoint++;
            }
            tempParam[inserPoint] = temp;
            inserPoint++;
        }

        while (leftPoint < leftSize){
            tempParam[inserPoint] = left[leftPoint];
            leftPoint++;
            inserPoint++;
        }
        while (rightPoint < rightSize){
            tempParam[inserPoint] = right[rightPoint];
            rightPoint++;
            inserPoint++;
        }
    }
}
