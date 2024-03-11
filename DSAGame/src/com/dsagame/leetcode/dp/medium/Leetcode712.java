package com.dsagame.leetcode.dp.medium;

public class Leetcode712 {
    public static void main(String[] args) {
        System.out.println(minimumDeleteSum("delete", "leet"));
        System.out.println(minimumDeleteSum("ccaccjp", "fwosarcwge"));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 0;
                } else if (i == dp.length - 1) {
                    dp[i][j] = s2.charAt(j) + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = s1.charAt(i) + dp[i + 1][j];
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(s1.charAt(i) + dp[i + 1][j], s2.charAt(j) + dp[i][j + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
