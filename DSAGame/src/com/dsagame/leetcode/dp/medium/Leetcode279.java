package com.dsagame.leetcode.dp.medium;

import java.util.Arrays;

public class Leetcode279 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; i - (j * j) >= 0; j++) {
                if (i - (j * j) >= 0) {
                    min = Math.min(min, dp[i - (j * j)]);
                }
            }
            dp[i] = 1 + min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
