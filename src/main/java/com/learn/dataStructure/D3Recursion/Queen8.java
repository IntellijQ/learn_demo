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
    // 下边代表row值 ，a[row] 代表column值
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
            // row = 5
            // a[5] = 1；
            if (isCanPutChesse(row)) {
                putChessPieces(row + 1);
            }
        }
    }

    /**
     * 是否可以下棋
     * @param row
     * @return
     */
    private static boolean isCanPutChesse(int row) {
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
