package com.dsagame.leetcode.dp.hard;

import java.util.Arrays;

public class Leetcode10 {
    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*i.*p*i"));
    }

    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*' && dp[i - 2][j]) {
                        dp[i][j] = true;
                    }
                } else {
                    if (p.charAt(i - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (p.charAt(i - 1) == s.charAt(j - 1) && dp[i - 1][j - 1]) {
                        dp[i][j] = true;
                    } else if (p.charAt(i - 1) == '*') {
                        if (p.charAt(i - 2) != s.charAt(j - 1) && p.charAt(i - 2) != '.') {
                            dp[i][j] = dp[i - 2][j];
                        } else if (dp[i - 2][j] || dp[i][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
