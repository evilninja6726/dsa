package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        System.out.println(lcr("abacbc"));
    }

    public static int lcr(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][0];
    }
}
