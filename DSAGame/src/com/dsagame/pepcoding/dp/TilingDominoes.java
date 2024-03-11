package com.dsagame.pepcoding.dp;

public class TilingDominoes {
    public static void main(String[] args) {
        System.out.println(ways(8));
        System.out.println(waysEff(8));
    }

    public static int ways(int n) {
        int[][] dp = new int[3][n + 1];
        for (int j = 1; j < n + 1; j++) {
            for (int i = 0; i < 3; i++) {
                if (j == 1) {
                    dp[1][j] = dp[2][j] = 1;
                } else {
                    if (i == 0) {
                        dp[i][j] = (j == 2) ? 1 : dp[i + 2][j - 2];
                    } else if (i == 1) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
                    }
                }
            }
        }
        return dp[2][n];
    }

    public static int waysEff(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }
        int horizontal = 1;
        int vertical = 1;
        int prevTotal = 1;
        int currTotal = 2;
        for (int i = 3; i <= n; i++) {
            horizontal = prevTotal;
            vertical = currTotal;
            prevTotal = currTotal;
            currTotal = horizontal + vertical;
        }
        return currTotal;
    }
}
