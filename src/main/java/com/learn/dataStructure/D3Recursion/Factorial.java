package com.learn.dataStructure.D3Recursion;

import java.math.BigDecimal;

/**
 * @author yds
 * @title: Factorial
 * @description: 阶乘
 * 5! = 5*4*3*2*1
 * @date 2020/10/30 11:43
 */
public class Factorial {
    public static void main(String[] args) {
        int n = 20;
        BigDecimal result = cal(n);
        System.out.println(n + "!=" + result);
    }

    private static BigDecimal cal(int n) {
        if(n == 1){
            return new BigDecimal(1);
        }
        return cal(n-1).multiply(new BigDecimal(n));
    }
}
