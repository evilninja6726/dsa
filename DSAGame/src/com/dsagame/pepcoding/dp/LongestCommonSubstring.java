package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        System.out.println(lcs("pqabcxy", "xyzabcp"));
    }

    public static int lcs(String s1, String s2) {
        int[][] dp = new int[s2.length()][s1.length()];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                boolean isSameChar = s1.charAt(j) == s2.charAt(i);
                if ((i == 0 || j == 0) && isSameChar) {
                    dp[i][j] = 1;
                } else if (isSameChar) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return res;
    }
}
