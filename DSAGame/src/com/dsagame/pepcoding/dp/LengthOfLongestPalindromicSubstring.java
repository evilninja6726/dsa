package com.dsagame.pepcoding.dp;

public class LengthOfLongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(length("abccbc"));
    }

    public static int length(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 1;
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else {
                    boolean isSameChar = s.charAt(i) == s.charAt(j);
                    if (gap == 1 && isSameChar) {
                        dp[i][j] = true;
                        res = Math.max(res, 2);
                    } else if (gap > 1 && isSameChar && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        res = Math.max(res, gap + 1);
                    }
                }
            }
        }
        return res;
    }
}
