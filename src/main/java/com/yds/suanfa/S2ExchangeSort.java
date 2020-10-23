package com.yds.suanfa;

/**
 * @author yds
 * @title: ExchangeSort
 * @description: 交换排序
 * @date 2020/8/21 15:46
 */
public class S2ExchangeSort {
    public static int[] param = {45,2,78,34,12,90,76,39,44,56,34,0,120,498,333,100,20};
//    public static int[] param = {45,2,78,34,12,90};
    public static void main(String[] args) {
//        bubbleSort(param);
        quickSort(0,param.length-1,param);
    }


    /**
     * 10 4 67 23 89
     * i=0 j<4
     * j=0 10>4  4 10 67 23 89
     * j=1 10<67 4 10 67 23 89
     * j=2 67>23 4 10 23 67 89
     * j=3 67<89 4 10 23 67 89
     * 从小到大
     * 冒泡排序 O(n2)
     * @author yds
     * @date 2020/8/21 15:47
     * @param param
     * @return void
    */
//    2 35 78 34
//    2 35 78 34
//    2 35 34 78
//
//    2 35 34 78
//    2 34 35 78
//
//    2 34 35 78
    public static void bubbleSort(int[] param){
        for(int i=0; i < param.length - 1; i++){
            System.out.println("第" + i + "轮");
            for(int j = 0; j < param.length - i -1; j++){
                System.out.println("比较" + j + "和" + (j + 1));
                int temp = param[j+1];
                if(param[j] > param[j+1]){
                    param[j+1] = param[j];
                    param[j] = temp;
                }
            }
        }
    }

    // 45
    // left=0 right=5 45,2,78,34,12,90
    // left=0 right=4 12,2,78,34,*,90
    // left=2 right=4 12,2,*,34,78,90
    // left=2 right=3 12,2,34,*,78,90
    // left=3 right=3 12,2,34,45,78,90

    // 12
    // left=0 right=2 12,2,34
    // left=0 right=1 2,*,34
    // left=1 right=1 2,*,34


    /**
     * 快速排序 O(nlog2 n)
     * @author yds
     * @date 2020/8/25 10:36
    */
//    快速排序（quick sort）是Hoare于1962年提出的一种分区交换排序。
//    它采用了一种分而治之的策略，是对冒泡排序的一种改进。
//    其算法思想是，
//    首先将待排序记录序列中的所有记录作为当前待排序区域，选取第一个记录的关键码值为基准（轴值），
//    从待排序记录序列左、右两端开始向中间靠拢，交替与轴值 !!!!!! 进行比较，
//    若左侧记录的关键码值大于轴值，则将该记录移到基准记录的右侧，进行右边比较
//    若右侧记录的关键码值小于轴值，则将该记录移到基准记录的左侧，进行左边比较
//    最后让基准记录到达它的最终位置，
//    此时，基准记录将待排序记录分成了左右两个区域，
//    位于基准记录左侧的记录都小于或等于轴值，
//    位于基准记录右侧的所有记录的关键码都大于或等于轴值，
//    这就是一趟快速排序；
//    然后分别对左右两个新的待排序区域，重复上述一趟快速排序的过程，其结果是分别让左、右两个区域中的基准记录都到达它们的最终位置，
//    同时将待排序记录序列分成更小的待排序区域，
//    再次重复对每个区域进行一趟快速排序，
//    直到每个区域只有一个记录为止，
//    此时所有的记录都到达了它的最终位置，即整个待排序记录按关键值有序排列，至此排序结束
    public static void quickSort(int left,int right,int[] param){
        if(left > right){
            return;
        }

        int i = left;
        int j = right;

        int target = param[left];
        System.out.println("基准值=" + target);
        while(j > i){
            //从右开始，查找小于目标值的第一个数，放在左边
            while (j > i){
                int temp = param[j];
                if(temp < target){
                    param[i] = temp;
                    i++;
                    break;
                }
                j--;
            }

            //从左开始，大于目标值，放在右边
            while(j > i){
                int temp = param[i];
                if(temp > target){
                    param[j] = temp;
                    j--;
                    break;
                }
                i++;
            }
        }

        if(i == j){
            param[j] = target;
            System.out.println("切分数据=" + i);
            //比较左
            quickSort(left,j-1,param);
            //比较右
            quickSort(j+1,right,param);
        }
    }
}
