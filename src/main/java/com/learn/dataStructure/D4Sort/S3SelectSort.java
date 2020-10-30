package com.learn.dataStructure.D4Sort;

/**
 * @author yds
 * @title: ExchangeSort
 * @description: 选择排序
 * @date 2020/8/21 15:46
 */
public class S3SelectSort {
    public static int[] param = {45,2,78,34,12,90,76,39,44,56,34,0,120,498,333,100,20};
//    public static int[] param = {4,7,8,10,15,12,0};
    public static void main(String[] args) {
//        selectionSort(param);
        heapSort(param);
    }
    /**
     * 简单选择排序 O(n2)
     * @author yds
     * @date 2020/8/24 16:30
     * @param param
     * @return void
    */
//    简单选择排序的算法思想是每一趟在n-i+1（i=1, 2, 3, …, n-1）个记录中选取关键码最小的记录作为有序序列中的第i个记录。
//    ① 将整个记录序列划分为有序区域和无序区域，有序区域位于最左端，无序区域位于右端，初始状态有序区域为空，无序区域含有待排序的所有n个记录。
//    ② 设置一个整型变量index，用于记录在一趟的比较过程中，当前关键码值最小的记录位置。
//    开始将它设定为当前无序区域的第一个位置，即假设这个位置的关键码最小，
//    然后用它与无序区域中其他记录进行比较，若发现有比它的关键码还小的记录，就将index改为这个新的最小记录位置，
//    随后再用L.r[index].key与后面的记录进行比较，并根据比较结果，随时修改index的值。一趟结束后，index中保留的就是本趟选择的关键码最小的记录位置。
//    ③ 将index位置的记录交换到无序区域的第一个位置，使得有序区域扩展了一个记录，而无序区域减少了一个记录
    public static void selectionSort(int[] param){
        for(int j = 0; j < param.length; j++){
            // 45 0,2,78,34,12,45
            // j = 0 param[0] = 45;
            // j = 1 min=0;

            // 45 0,2,78,34,12,45

            int minIndex = j;
            int minValue = param[j];
            int currentValue = param[j];

            for(int i= j + 1; i< param.length; i++){
                int temp = param[i];
                if(temp < minValue){
                    minIndex = i;
                    minValue = temp;
                }
            }

            if(minIndex != j){
                param[j] = minValue;
                param[minIndex] = currentValue;
            }
        }
    }


    /**
     * 堆排序 O(n log n)
     * @author yds
     * @date 2020/8/25 16:09
     * @param param
     * @return void
    */
//    （1）堆是指n个元素的序列{k1, k2, …, kn}当且仅当满足以下关系时，称为堆，
//        满足"每个结点的值都小于或等于其左右孩子结点的值"关系的称为最小堆，
//        满足"每个结点的值都大于或等于其左右孩子结点的值"关系的称为最大堆
//    （2）堆排序（heap sort）是指若在输出堆顶的最大（小）值之后，使得剩余n-1个元素的序列重又建成一个堆，则得到n个元素中的次大（小）值。
//    如此反复执行，便能得到一个有序序列，这个过程称为堆排序。堆排序只需要一个记录大小的辅助空间，每个待排序的记录仅占有一个存储空间。
    public static void heapSort(int[] param){
        int length = param.length;
        //从最后一个非叶结点 开始 构建最大堆
        for(int i = (length - 1 - 1)/2; i >=0; i--){
            heapify(param, i,length);
        }

        //堆排序
        for(int i = length - 1; i > 0; i--){
            int maxValue = param[0];
            param[0] = param[i];
            param[i] = maxValue;
            length--;
            heapify(param,0,i);
        }
    }


    public static void heapify(int[] param,int i,int length){
        int largeIndex = i;
        int leftIndex = 2 *  i + 1;
        int rightIndex = 2 * i + 2;

        if(leftIndex < length && param[leftIndex] > param[largeIndex]){
            largeIndex = leftIndex;
        }
        if(rightIndex < length && param[rightIndex] > param[largeIndex]){
            largeIndex = rightIndex;
        }

        if(largeIndex != i){
            //交互数据
            int temp = param[i];
            param[i] = param[largeIndex];
            param[largeIndex] = temp;
            //递归调用
            heapify(param,largeIndex,length);
        }
    }
}
