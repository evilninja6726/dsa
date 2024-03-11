package com.dsagame.leetcode.dp.medium;

public class Leetcode1039 {
    public static void main(String[] args) {
        System.out.println(minScoreTriangulation(new int[]{3, 7, 4, 5}));
        System.out.println(minScoreTriangulation(new int[]{1, 2, 3}));
        System.out.println(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5}));
    }

    public static int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length - 1][values.length - 1];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp.length; i++, j++) {
                if (gap == 1) {
                    dp[i][j] = values[i] * values[j] * values[j + 1];
                } else if (gap != 0) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j] + values[i] * values[k + 1] * values[j + 1]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }
}
