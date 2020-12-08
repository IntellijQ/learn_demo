package com.learn.dataStructure.D8Algorithm.A2Dynamic.StringPatter;

import java.util.Arrays;

/**
 * @author yds
 * @title: StringPatterViolence
 * @description: 使用kmp进行搜索查询
 * @date 2020/11/27 15:32
 */
public class StringPatter02Kmp {

    public static void main(String[] args) {
        String source = "BBC ABCDAB ABCDABCDABDA";
        String target = "ABCDABDA";
//        String target = "ABCABCAAA";
//        String target = "ABABCABAA";

        int index = matchTarget(source, target);
        System.out.println(index);

    }

    private static int matchTarget(String source, String target) {
        if (source == null || "".equals(source)) {
            throw new RuntimeException("待查找内容不可为空");
        }

        if (target == null || "".equals(target)) {
            throw new RuntimeException("查找内容不可为空");
        }

        // 创建字符串部分匹配值表
        int[] patterTable = getPatterTable(target);
        System.out.println(Arrays.toString(patterTable));

        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                if (j - 1 < 0) {
                    i++;
                } else {
                    int moveValue = j - patterTable[j - 1];
                    j = j - moveValue;
                }
            }

            if (j == target.length()) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 创建字符串部分匹配值表
     * index = target对应的下标
     * int[index] = 截至target对应的下标位置的字符串，公共最长前后缀值
     * @param target
     * @return
     */
    private static int[] getPatterTable(String target) {
        int[] patterTable = new int[target.length()];
        // 截至当前字符串的公共最长前后缀值
        int k = 0;
        // 当只有一个字符的时候，该字符的公共最长前后缀为0
        patterTable[0] = k;
        // 从1开始
        int j = 1;

        while (j < target.length()) {
            if (target.charAt(j) != target.charAt(k) && k> 0){
                k = patterTable[k - 1];
                continue;
            }

            if (target.charAt(j) == target.charAt(k)) {
                k++;
            }
            patterTable[j] = k;
            j++;
        }
//
//        for (int j = 1; j < target.length(); j++) {
//            while (k > 0 && target.charAt(j) != target.charAt(k)) {
//                k = patterTable[k - 1];
//            }
//            if (target.charAt(j) == target.charAt(k)) {
//                k++;
//            }
//            patterTable[j] = k;
//        }

        return patterTable;
    }


    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
