package com.dsagame.leetcode.dp.medium;

public class Leetcode688 {
    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }

    public static double helper(int n, int k, int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        double res = 0;
        res += helper(n, k - 1, row - 2, col + 1) +
                helper(n, k - 1, row - 2, col - 1) +
                helper(n, k - 1, row + 2, col + 1) +
                helper(n, k - 1, row + 2, col - 1) +
                helper(n, k - 1, row - 1, col + 2) +
                helper(n, k - 1, row - 1, col - 2) +
                helper(n, k - 1, row + 1, col + 2) +
                helper(n, k - 1, row + 1, col - 2);

        return res / 8;
    }

    public static double helper(int n, int k, int row, int col, double[][][] dp) {
        if (row < 0 || col < 0 || row >= n || col >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[k][row][col] != 0) {
            return dp[k][row][col];
        }
        double res = 0;
        res += helper(n, k - 1, row - 2, col + 1, dp) +
                helper(n, k - 1, row - 2, col - 1, dp) +
                helper(n, k - 1, row + 2, col + 1, dp) +
                helper(n, k - 1, row + 2, col - 1, dp) +
                helper(n, k - 1, row - 1, col + 2, dp) +
                helper(n, k - 1, row - 1, col - 2, dp) +
                helper(n, k - 1, row + 1, col + 2, dp) +
                helper(n, k - 1, row + 1, col - 2, dp);
        dp[k][row][col] = res / 8;
        return res / 8;
    }

    public static double knightProbability(int n, int k, int row, int column) {
        //  return helper(n, k, row, column);
        return helper(n, k, row, column, new double[k + 1][n][n]);
    }
}
