package com.dsagame.pepcoding.dp;

public class PartitionInKSubset {
    public static void main(String[] args) {
        System.out.println(partition(4, 3));
    }

    public static long partition(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];  //because of multiplication
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= k; i++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (i < j) {
                    dp[i][j] = i * dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[k][n];
    }
}
