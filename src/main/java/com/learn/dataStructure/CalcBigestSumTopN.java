package com.learn.dataStructure;

/**
 * @author yds
 * @title: CalcBigestSumTopN
 * @description: TODO
 * @date 2021/3/7 22:00
 */
public class CalcBigestSumTopN {

    public static int comp(int a, int b) {
        if (a == b)
            System.out.println("a==b");
        return a >= b ? a : b;
    }

    public static int sumTopN(int[] arr) {
        if (arr.length == 0)
            return -1;
        if (arr.length == 1)
            return arr[0];
        if (arr.length == 2)
            return comp(arr[0], arr[1]);

        int a = arr[0];
        int b = comp(arr[0], arr[1]);
        int c = 0;

        for (int i = 2; i < arr.length; i++) {
            c = comp(a + arr[i], b);
            System.out.println(c);
            a = b;
            b = c;
        }
        System.out.println("c= " + c);
        return c;
    }

    //1个数的时候，a[0]
    //2个数的时候，a[0] 或者 a[1]
    //3个数的时候，a[0] + a[2] 或者 a[1]
    //0 1 2 3  max4= max(2) + a[3],max(3)
    //4个数的时候，a[0] + a[2] 或者 a[0] + a[3] 或者 a[1] + a[3]
    //0 1 2 3 4 max5= max(3) + a[4],max(4)
    //5个数的时候，a[0] + a[2] + a[4] 或者 a[1] + a[4]  或者 a[0] + a[3] 或者 a[1] + a[3]
    //0 1 2 3 4 5
    //6个数的时候，a[0] + a[2] + a[4] 或者 a[0] + a[3] + a[5] 或者 a[1] + a[3] + a[5]


    public static void main(String[] args) {
        int[] arr = { 5, 4, 10, 100, 10, 5, 7 };
        int x = sumTopN(arr);
        System.out.println("x= " + x);

    }
}
