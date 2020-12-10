package com.learn.dataStructure.D8Algorithm.A5UnionFind;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yds
 * @title: WhiteBlack
 * @description: 被围绕的区域：给你一个 M×N 的二维矩阵，其中包含字符 X 和 O，让你找到矩阵中四面被 X 围住的 O，并且把它们替换成 X。
 * @date 2020/12/9 17:25
 */
public class WhiteBlack {
    final static String A = "A";
    final static String X = "X";
    final static String O = "O";
    int row = 5;
    int column = 5;
    String[][] board = new String[row][column];

    public String[][] createBoard() {
        board[0] = new String[]{"O", "O", "X", "X", "O"};
        board[1] = new String[]{"X", "X", "X", "O", "X"};
        board[2] = new String[]{"X", "O", "X", "O", "X"};
        board[3] = new String[]{"X", "X", "X", "X", "X"};
        board[4] = new String[]{"X", "O", "X", "X", "X"};
        return board;
    }

    public static void main(String[] args) {
        WhiteBlack whiteBlack = new WhiteBlack();
        String[][] board = whiteBlack.createBoard();
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println();

        whiteBlack.dfs(board);
        whiteBlack.bfs(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    /**
     * 深度优先遍历
     * @param board
     */
    public void dfs(String[][] board){
        // 清除行边界O变为A
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);// 行头
            dfs(board, i, column - 1);// 行尾
        }

        for (int i = 1; i < column - 1; i++) {
            dfs(board, 0, i);// 列头
            dfs(board, row - 1, i);// 列尾
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == A) {
                    board[i][j] = O;
                } else if (board[i][j] == O) {
                    board[i][j] = X;
                }
            }
        }
    }

    private void dfs(String[][] board, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= column || board[x][y] != O) {
            return;
        }
        board[x][y] = "A";
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }


    /**
     * 广度优先遍历
     * @param board
     */
    public void bfs(String[][] board) {
        // 队列
        Queue<int[]> queue = new LinkedList<int[]>();

        // 清除行边界O变为A
        for (int i = 0; i < row; i++) {
            if (board[i][0] == O) {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][column - 1] == O) {
                queue.offer(new int[]{i, column - 1});
            }
        }
        for (int i = 1; i < column - 1; i++) {
            if (board[0][i] == O) {
                queue.offer(new int[]{0, i});
            }
            if (board[row - 1][i] == O) {
                queue.offer(new int[]{row - 1, i});
            }
        }

        // 坐标方向
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            board[x][y] = A;
            for (int i = 0; i < 4; i++) {
                // 上下左右 四个方向
                // 上 x-1,y
                // 下 x+1,y
                // 左 x,y-1
                // 右 x,y+1
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx < 0 || my < 0 || mx >= row || my >= column || board[mx][my] != O) {
                    continue;
                }
                queue.offer(new int[]{mx, my});
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == A) {
                    board[i][j] = O;
                } else if (board[i][j] == O) {
                    board[i][j] = X;
                }
            }
        }
    }
}
