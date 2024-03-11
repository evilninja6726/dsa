package com.dsagame.pepcoding.dp;

public class MinCostToMakeTwoStringsIdentical {
    public static void main(String[] args) {
        System.out.println(minCost("sea", "eat", 10, 7));
    }

    public static int minCost(String s1, String s2, int x, int y) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 || j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = 1 + dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return x * (s1.length() - dp[0][0]) + y * (s2.length() - dp[0][0]);
    }
}
