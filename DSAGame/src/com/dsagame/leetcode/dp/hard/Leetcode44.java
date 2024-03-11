package com.dsagame.leetcode.dp.hard;

import java.util.Arrays;

public class Leetcode44 {
    public static void main(String[] args) {
        System.out.println(isMatch("baaabab", "ba*a?"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[p.length()][s.length()] = true;
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if ((i < dp.length - 1 && j == dp[0].length - 1 && p.charAt(i) == '*' && dp[i + 1][j]) || (i != dp.length - 1) && (j != dp[0].length - 1) && ((p.charAt(i) == '?' && dp[i + 1][j + 1]) || (p.charAt(i) == s.charAt(j) && dp[i + 1][j + 1]) || (p.charAt(i) == '*' && (dp[i + 1][j] || dp[i][j + 1])))) {
                    dp[i][j] = true;
                }
            }
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[0][0];
    }
}
