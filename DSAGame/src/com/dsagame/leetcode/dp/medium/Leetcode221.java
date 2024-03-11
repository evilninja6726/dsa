package com.dsagame.leetcode.dp.medium;

import java.util.Arrays;

public class Leetcode221 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] chars = new char[][]{
                {'0', '1'}, {'1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int res = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return res * res;
    }
}
