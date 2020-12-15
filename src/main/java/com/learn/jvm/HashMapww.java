package com.learn.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yds
 * @title: HashMapww
 * @description: TODO
 * @date 2020/12/14 14:40
 */
public class HashMapww {


    public static void main(String[] args) {

        System.out.println(65 & 2);
        System.out.println(65 & 3);
        System.out.println(66 & 2);
        System.out.println(66 & 3);
        HashMap<String, Object> objectObjectHashMap1 = new HashMap<>(2,1F);
        objectObjectHashMap1.put("A","ddd");
        objectObjectHashMap1.put("B","ddd");
        objectObjectHashMap1.put("C","ddd");
        objectObjectHashMap1.get("");

        int index = 0;
        String[] names = {"令狐冲", "张无忌", "韦小宝", "杨过", "段誉", "乔峰"};
        System.out.println(names[++index]); //打印出张无忌
        System.out.println(index);//1
        System.out.println(names[index++]); //打印出张无忌
        System.out.println(index);//2
        System.out.println(names[++index]);   //打印出杨过


        System.out.println(testIsPrime3(9));;

        System.out.println(Integer.toBinaryString("name22222".hashCode()));
        System.out.println(Integer.toBinaryString("name22222".hashCode() >>> 16));
        // 按位或运算符（|） 有1就是1====0|0=0； 0|1=1；  1|0=1；   1|1=1；
        System.out.println("按位或运算符（|）" + Integer.toBinaryString("name22222".hashCode() | "name22222".hashCode() >>> 16));
        // 按位与运算符（&） 有0就是0====0&0=0;  0&1=0;   1&0=0;    1&1=1;
        System.out.println("按位与运算符（&）" + Integer.toBinaryString("name22222".hashCode() & "name22222".hashCode() >>> 16));
        // 异或运算符（^） 同是0====0^0=0；  0^1=1；  1^0=1；   1^1=0
        System.out.println("异或运算符（^）" + Integer.toBinaryString("name22222".hashCode() ^ "name22222".hashCode() >>> 16));
        System.out.println(("name22222".hashCode() ^ "name22222".hashCode() >>> 16));
        System.out.println(15 & ("jintiantdetianqdsfdsafafa".hashCode()));
        System.out.println(15 & ("jintiantdetianqdsfdsafafa".hashCode() ^ "jintiantdetianqdsfdsafafa".hashCode() >>> 16));

        Map<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("dd","dd");
        objectObjectHashMap.put("dd1","dd2");
        System.out.println(objectObjectHashMap);
    }


    public static boolean testIsPrime3(int n){
        if (n <= 3) {
            return n > 1;
        }

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
