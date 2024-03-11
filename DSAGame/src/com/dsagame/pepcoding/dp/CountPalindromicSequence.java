package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class CountPalindromicSequence {
    public static void main(String[] args) {
        System.out.println(count("abccbc"));
    }

    public static int count(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1 && s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = 2;
                } else if (gap == 1) {
                    dp[i][j] = 3;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][s.length() - 1];
    }
}
