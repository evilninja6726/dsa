package com.dsagame.leetcode.dp.medium;

public class Leetcode647 {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abccbc"));
    }

    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = s.length();
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else {
                    boolean isSameChar = s.charAt(i) == s.charAt(j);
                    if (gap == 1 && isSameChar) {
                        dp[i][j] = true;
                        res++;
                    } else if (gap > 1 && isSameChar && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
