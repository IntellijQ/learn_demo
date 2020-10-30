package com.learn.dataStructure.D3Recursion;

/**
 * @author yds
 * @title: Queue8
 * @description: 八皇后问题
 * @date 2020/10/29 10:25
 */
public class Queen8 {

    static int queueCount = 0;
    static int max = 8;
    static int[] array = new int[max];

    public static void main(String[] args) {
        putChessPieces(0);
        System.out.printf("八皇后解法共有%d种", queueCount);
    }


    private static void putChessPieces(int row) {
        if (row == max) {
            printSuccessQueue();
            return;
        }

        for (int i = 0; i < max; i++) {
            array[row] = i;
            if (isCanPut(row)) {
                putChessPieces(row + 1);
            }
        }
    }

    private static boolean isCanPut(int row) {
        for (int i = 0; i < row; i++) {
            if (array[i] == array[row]) { // 列有攻击
                return false;
            }

            if (Math.abs(row - i) == Math.abs(array[row] - array[i])) { // 斜线有攻击
                return false;
            }
        }
        return true;
    }


    private static void printSuccessQueue() {
        queueCount++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println("");
    }
}
