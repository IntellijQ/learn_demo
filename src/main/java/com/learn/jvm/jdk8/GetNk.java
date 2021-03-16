package com.learn.jvm.jdk8;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yds
 * @title: GetNk
 * @description: TODO
 * @date 2021/1/7 18:41
 */
public class GetNk {
    static Map<Integer, int[]> map = new HashMap<Integer, int[]>();

    public static void main(String[] args) {
        initArray(1, 10);

        System.out.println(JSON.toJSONString(map));
        System.out.println(getNum(3,7));
    }

    public static void initArray(int initItem, int createArrayNum) {
        int[] array = {initItem};
        map.put(0, array);

        for (int i = 1; i <= createArrayNum; i++) {
            int[] lastArray = map.get(i - 1);
            int[] currentArray = createArray(i, lastArray);
            map.put(i, currentArray);
        }
    }

    public static int[] createArray(int n, int[] array) {
        int[] newArray = new int[array.length * 2 + 1];
        newArray[array.length] = n + 1;

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
            newArray[array.length + 1 + i] = array[i];
        }
        return newArray;
    }


    public static int getNum(int n,int k) {
        int[] array = map.get(n);

        if(array == null){
            throw new RuntimeException("查询的数组不存在，请初始化数组");
        }
        if(k >= array.length){
            throw new RuntimeException("查询的数组下标不合法，最大为：" + (array.length - 1));
        }

        return array[k];
    }
}
