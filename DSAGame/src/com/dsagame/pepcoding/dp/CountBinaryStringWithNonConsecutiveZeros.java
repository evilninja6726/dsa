package com.dsagame.pepcoding.dp;

public class CountBinaryStringWithNonConsecutiveZeros {
    public static void main(String[] args) {
        System.out.println(count(6));
        System.out.println(countEff(6));
        System.out.println(count(7));
        System.out.println(countEff(7));
        System.out.println(count(8));
        System.out.println(countEff(8));
        System.out.println(count(9));
        System.out.println(countEff(9));
    }

    public static int count(int n) {
        int[][] dp = new int[2][n + 1];
        for (int j = 0; j < n + 1; j++) {
            for (int i = 0; i < 2; i++) {
                if (j == 0 || j == 1) {
                    dp[i][j] = j;
                } else if (i == 0) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }
            }
        }
        return dp[0][n] + dp[1][n];
    }

    public static int countEff(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 2;
        }
        int endWithZeroCount = 1;
        int endWithOneCount = 1;
        for (int i = 2; i <= n; i++) {
            int temp = endWithZeroCount;
            endWithZeroCount = endWithOneCount;
            endWithOneCount += temp;
        }
        return endWithZeroCount + endWithOneCount;
    }
}
