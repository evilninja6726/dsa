package com.dsagame.leetcode.dp.easy;

public class Leetcode70 {
    public static void main(String[] args) {

    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
