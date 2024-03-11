package com.dsagame.leetcode.recursion.hard;

import java.util.ArrayList;
import java.util.List;

public class Leetcode51 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> innerList = new ArrayList<>();
        placeNQueens(new int[n][n], 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1], innerList, res);
        return res;
    }

    public static void placeNQueens(int[][] chess, int row, boolean[] columns, boolean[] normalDiagonal, boolean[] reverseDiagonal, List<String> nestedList, List<List<String>> res) {
        if (row == chess.length) {
            res.add(new ArrayList<>(nestedList));
        }
        for (int i = 0; i < chess[0].length; i++) {
            if (isSafe(chess, columns, normalDiagonal, reverseDiagonal, row, i)) {
                chess[row][i] = 1;
                columns[i] = true;
                normalDiagonal[row + i] = true;
                reverseDiagonal[row - i + chess.length - 1] = true;
                StringBuilder rowString = new StringBuilder(".".repeat(chess.length));
                rowString.setCharAt(i, 'Q');
                nestedList.add(rowString.toString());
                placeNQueens(chess, row + 1, columns, normalDiagonal, reverseDiagonal, nestedList, res);
                chess[row][i] = 0;
                columns[i] = false;
                normalDiagonal[row + i] = false;
                reverseDiagonal[row - i + chess.length - 1] = false;
                nestedList.remove(nestedList.size() - 1);
            }
        }
    }

    public static boolean isSafe(int[][] chess, boolean[] columns, boolean[] normalDiagonal, boolean[] reverseDiagonal, int row, int column) {
        return !columns[column] && !normalDiagonal[row + column] && !reverseDiagonal[row - column + chess.length - 1];
    }
}
