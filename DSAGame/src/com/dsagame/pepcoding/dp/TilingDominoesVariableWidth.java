package com.dsagame.pepcoding.dp;

public class TilingDominoesVariableWidth {
    public static void main(String[] args) {
        System.out.println(ways(39, 16));
    }

    public static int ways(int n, int m) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }
}
