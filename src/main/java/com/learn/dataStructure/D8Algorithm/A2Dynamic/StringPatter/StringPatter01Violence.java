package com.learn.dataStructure.D8Algorithm.A2Dynamic.StringPatter;

/**
 * @author yds
 * @title: StringPatterViolence
 * @description: 暴力匹配字符串
 * @date 2020/11/27 15:32
 */
public class StringPatter01Violence {
    public static void main(String[] args) {

        String source = "BBC ABCDAB ABCDABCDABDE";
        String target = "ABCDABD";

        int index = matchTarget(source, target);
        System.out.println(target + "在下标source[" + index+ "]处查询到");
    }

    private static int matchTarget(String source, String target) {
        if(source == null || "".equals(source)){
            throw new RuntimeException("待查找内容不可为空");
        }

        if(target == null || "".equals(target)){
            throw new RuntimeException("查找内容不可为空");
        }

        int i = 0;
        int j = 0;
        while (i <source.length() && j < target.length()){
            if(source.charAt(i) == target.charAt(j)){
                i++;
                j++;
            }else {
                i= i -j + 1;
                j=0;
            }
            if(j == target.length()){
                return i - j;
            }
        }
        return -1;
    }
}
