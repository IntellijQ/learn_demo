package com.learn.dataStructure.D5Search;

import java.util.Arrays;

/**
 * @author yds
 * @title: S3FibonacciSearch
 * @description: 斐波那契查询
 * @date 2020/11/10 18:36
 */
public class S4FibonacciSearch {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 3, 3, 6, 7};
        int target = 3;
        fibonacciSearch(target, array);

        System.out.println(fibonacci1(10));
        System.out.println(fibonacci2(10));
        System.out.println(fibonacci3(10, 1, 1));
    }

    private static int fibonacciSearch(int target, int[] array) {
        // 1.构建斐波那契数组
        int[] fib = fibonacci();
//        System.out.println(Arrays.toString(fib));

        // 2.使array.length >= fib[k] - 1,获取fib[k]最小值
        int an = array.length;
        int k = 0;
        while (an >= fib[k] - 1) {
            k++;
        }
        // 3.填充数组
        int[] temp = Arrays.copyOf(array, fib[k]);
        for (int i = an; i < fib[k]; i++) {
            temp[i] = array[an - 1];
        }
        System.out.println(Arrays.toString(temp));


        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (fib[k - 1] - 1);
            if (temp[mid] == target) {
                if (right < mid) {
                    return right;
                }
                return mid;
            }

            // 查左边
            if (target < temp[mid]) {
                right = mid - 1;

                k--;

            }
            // 查右边
            if (target > temp[mid]) {
                left = mid + 1;
                k -= 2;
            }
        }
        return -1;
    }

    private static int[] fibonacci() {
        int maxSize = 47;
        int[] fib = new int[maxSize];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(fib[maxSize - 1]);
//        System.out.println(fib[maxSize - 2]);
//        System.out.println(fib[maxSize - 3]);
//        System.out.println(Integer.MAX_VALUE < fib[maxSize - 2]);
        return fib;
    }


    /**
     * 递归
     *
     * @param n
     * @return
     */
    private static int fibonacci1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    private static int fibonacci2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }


    /**
     * 尾递归
     *
     * @param n
     * @param ret1 第一个数
     * @param ret2 第二个数
     * @return
     */
    private static int fibonacci3(int n, int ret1, int ret2) {
        if (n == 2) {
            return ret2;
        }
        //开始 fibonacci3(8,1,1)
        //fibonacci3(7,1,2)
        //fibonacci3(6,2,3)
        //fibonacci3(5,3,5)
        //fibonacci3(4,5,8)
        //fibonacci3(3,8,13)
        //fibonacci3(2,13,21)
        //fibonacci3(1,21,34)
//        System.out.println("------" + (n - 1) + "," + ret2 + ", " + (ret1 + ret2));
        return fibonacci3(n - 1, ret2, ret1 + ret2);
    }
}
