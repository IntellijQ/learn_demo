package com.learn.dataStructure.D3Recursion;

/**
 * @author yds
 * @title: FibonacciSequence
 * @description:
 * 斐波那契数列（Fibonacci sequence），又称黄金分割数列、
 * 因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）以兔子繁殖为例子而引入，故又称为“兔子数列”，
 * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
 * 在数学上，斐波纳契数列以如下被以递推的方法定义：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*）
 * @date 2020/10/30 11:51
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        int index = 8;

        int num = fbsNum(index);

        System.out.println(num);
    }

    private static int fbsNum(int index) {
        if(index == 0){
            return 1;
        }
        if(index == 1){
            return 1;
        }
        return fbsNum(index - 1) + fbsNum(index - 2);
    }


}
