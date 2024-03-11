package com.dsagame.leetcode.dp.medium;

public class Leetcode72 {
    public static void main(String[] args) {
        System.out.println(minDistanceRec("intention", "execution"));
        System.out.println(minDistance("intention", "execution"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static int minDistanceRec(String word1, String word2) {
        return helper(word1, word2, 0, 0);
    }

    public static int helper(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        int res = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            res += helper(s1, s2, i + 1, j + 1);
        } else {
            res = 1 + Math.min(helper(s1, s2, i + 1, j + 1), Math.min(helper(s1, s2, i + 1, j), helper(s1, s2, i, j + 1)));
        }
        return res;
    }
}
