package com.dsagame.pepcoding.dp;

public class OptimalStrategyForAGame {
    public static void main(String[] args) {
        System.out.println(max(new int[]{20, 30, 2, 10}));
    }

    public static int max(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = arr[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {
                    dp[i][j] = Math.max(arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]), arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]));
                }
            }
        }
        return dp[0][arr.length - 1];
    }
}
