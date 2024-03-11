package com.dsagame.pepcoding.graphs;

import java.util.Arrays;

public class KnightTour {
    public static void main(String[] args) {
        knightTour(5, 2, 2);
    }

    public static void knightTour(int n, int row, int column) {
        helper(new int[n][n], row, column, 1);
    }

    public static void print(int[][] chess) {
        for (int[] arr : chess) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void helper(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] > 0) {
            return;
        }
        if (move == chess.length * chess.length) {
            chess[row][col] = move;
            print(chess);
            chess[row][col] = 0;
            return;
        }
        chess[row][col] = move;
        helper(chess, row - 2, col + 1, move + 1);
        helper(chess, row - 1, col + 2, move + 1);
        helper(chess, row + 1, col + 2, move + 1);
        helper(chess, row + 2, col + 1, move + 1);
        helper(chess, row + 2, col - 1, move + 1);
        helper(chess, row + 1, col - 2, move + 1);
        helper(chess, row - 1, col - 2, move + 1);
        helper(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }
}
