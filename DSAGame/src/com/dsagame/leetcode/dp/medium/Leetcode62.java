package com.dsagame.leetcode.dp.medium;

public class Leetcode62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        for (int i = 1; i <= n; i++) {
            dp[i - 1] = i;
        }
        for (int i = 2; i < m; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
