package com.dsagame.pepcoding.recandbt;

import java.util.Arrays;

public class Sudoku {
    public static void main(String[] args) {
        sudoku(new int[][]
                {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}});
    }

    public static void sudoku(int[][] board) {
        helper(board, 0, 0);
    }

    public static void helper(int[][] board, int row, int column) {
        if (row == board.length) {
            for (int[] arr : board) {
                System.out.println(Arrays.toString(arr));
            }
            return;
        }
        int nextRow = row;
        int nextColumn = column;
        if (column == board[column].length - 1) {
            nextRow = row + 1;
            nextColumn = 0;
        } else {
            nextColumn = column + 1;
        }
        if (board[row][column] != 0) {
            helper(board, nextRow, nextColumn);
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isPossible(row, column, i, board)) {
                    board[row][column] = i;
                    helper(board, nextRow, nextColumn);
                    board[row][column] = 0;
                }
            }
        }
    }

    public static boolean isPossible(int row, int column, int currentNum, int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == currentNum) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == currentNum) {
                return false;
            }
        }
        int[] parent = parent(row, column);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[parent[0] + i][parent[1] + j] == currentNum) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] parent(int row, int column) {
        int[] parent = new int[2];
        parent[0] = row / 3 * 3;
        parent[1] = column / 3 * 3;
        return parent;
    }
}
