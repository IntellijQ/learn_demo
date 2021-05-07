package com.learn.dataStructure;

import java.util.Arrays;

/**
 * @author yds
 * @title: CheckNum
 * @description: TODO
 * @date 2020/7/20 20:17
 */
public class CheckNum {
    public static void main(String[] args) {
//        int[] source = {2,4,6,9,10,34,40,59,120};
//        findNumIndexBetween(2,source);
//
//
//
//        int[] source2 = {12,44,6,9,5,3,40,123,120};
//        findNumIndexBlock(12,source2);
        int[] source = {2, 4, 6, 9, 10, 34, 40, 59, 120};
        int index = findIndex(source, 8);
        int[] source2 = new int[source.length + 1];

        for (int i = 0; i < source2.length; i++) {
            if(i < index){
                source2[i] = source[i];
            }else if(i == index){
                source2[i] = 8;
                source2[i + 1] = source[i];
                i++;
            }else{
                source2[i] = source[i-1];
            }
        }
    }


    public static int findIndex(int[] a, int insertNum) {
        int begin = 0;
        int end = a.length - 1;

        while (begin != end) {

            if (a[begin] >= insertNum) {
                System.out.println("插入值小于等于开头值：" + a[begin] + ",放到该值前");
                return 0;
            }

            if (a[end] <= insertNum) {
                System.out.println("插入值大于等于结尾值：" + a[end] + ",放到该值后");
                return end;
            }

            int mid = (begin + end) / 2;
            System.out.println("开始位置：" + begin + ",结束位置：" + end + "，中间位置：" + mid);

            if (mid - begin == 1 && end - mid == 1) {
                System.out.println("位置相邻：" + begin + ",结束位置：" + end + "，中间位置：" + mid);
                return end;
            }

            if (a[mid] == insertNum) {
                System.out.println("插入值等于中间值：" + a[mid] + ",放到该值后");
                return mid;
            }

            if (a[mid] > insertNum) {
                end = mid - 1;
            } else if (a[mid] < insertNum) {
                begin = mid + 1;
            }
        }

        System.out.println("最后位置：" + end);
        return end;
    }

    public static int findNumIndexBySort(int target, int[] source) {
        for (int i = 0; i < source.length; i++) {
            if (target == source[i]) {
                System.out.println("已找到该数据,下标为:" + i);
                return i;
            }
        }
        throw new RuntimeException("暂未找到该数据");
    }

    public static NodeIndex[] creatIndexList(int[] source, int blockNum) {
        NodeIndex[] indexList = new NodeIndex[blockNum];
        int sourceLength = source.length;
        int avgNum = sourceLength / blockNum;
        int modNum = sourceLength % blockNum;
        int index = 0;

        int blockStartIndex = 0;
        int blockEndIndex = avgNum - 1;
        while (blockNum > 0) {
            NodeIndex nodeIndex = new NodeIndex();
            int max = source[blockStartIndex];
            for (int i = blockStartIndex; i <= blockEndIndex; i++) {
                if (source[i] > max) {
                    max = source[i];
                    break;
                }
            }
            nodeIndex.setValue(max);//max value
            nodeIndex.setPindex(blockEndIndex);
            indexList[index] = nodeIndex;

            blockStartIndex += avgNum;
            blockEndIndex += avgNum;
            if (blockEndIndex > (sourceLength - 1) || blockEndIndex + modNum == sourceLength - 1) {
                blockEndIndex = sourceLength - 1;
            }
            index++;
            blockNum--;
        }

        Arrays.sort(indexList, (o1, o2) -> {
            return o1.getValue() - o2.getValue();
        });

        return indexList;
    }

    //98
    //2 45 78 98 100
    public static int findNumIndexBetween(int target, int[] source) {

        int low = 0;
        int high = source.length - 1;//4
        while (low <= high) {
            int between = (high + low) / 2;//2 78
            if (target > source[between]) low = between + 1;
            else if (target < source[between]) high = between - 1;
            else {
                System.out.println("找到" + target + "，下标为" + between);
                return between;
            }
        }
        throw new RuntimeException("暂未找到");
    }


    public static int findNumIndexBlock(int target, int[] source) {
        NodeIndex[] index = creatIndexList(source, 4);
        for (NodeIndex nodeIndex : index) {
            System.out.println(nodeIndex.toString());
        }


        int low = 0;
        int high = index.length - 1;
        while (low <= high) {
            int between = (high + low) / 2;
            if (target > index[between].getValue()) low = between + 1;
            else if (target <= index[between].getValue()) break;
        }

        int targetIndex = (high + low) / 2;
        System.out.println("目标所在索引列为：" + targetIndex);

        NodeIndex nodeIndex = index[targetIndex];
        int sourceLength = source.length;
        int avgNum = sourceLength / 4;

        int end = nodeIndex.getPindex();
        int start = end + 1 - avgNum;
        if (end == source.length - 1) {
            start = end - avgNum;
        }

        for (int i = start; i <= end; i++) {
            if (target == source[i]) {
                System.out.println("找到目前，目标下标：" + i);
                return i;
            }
        }

        throw new RuntimeException("暂未找到目标");
    }


    public static class NodeIndex {
        private int value;
        private int pindex;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getPindex() {
            return pindex;
        }

        public void setPindex(int pindex) {
            this.pindex = pindex;
        }

        @Override
        public String toString() {
            return "NodeIndex{" +
                    "value=" + value +
                    ", pindex=" + pindex +
                    '}';
        }
    }
}
