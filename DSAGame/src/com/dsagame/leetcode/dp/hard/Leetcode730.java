package com.dsagame.leetcode.dp.hard;

import java.util.Arrays;

public class Leetcode730 {
    public static void main(String[] args) {
//        System.out.println(countPalindromicSubsequences("abacdaea"));
//        System.out.println(countPalindromicSubsequences("bccb"));
        System.out.println(countPalindromicSubsequences("bcbacbabdcbcbdcbddcaaccdcbbcdbcabbcdddadaadddbdbbbdacbabaabdddcaccccdccdbabcddbdcccabccbbcdbcdbdaada"));
    }

    public static int countPalindromicSubsequences(String s) {
        final int MOD = 1000000007;
        int[] nextOfCurr = new int[s.length()];
        int[] prevOfCurr = new int[s.length()];
        int[] currIndex = new int[26];
        Arrays.fill(currIndex, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            if (currIndex[currChar - 'a'] == -1) {
                nextOfCurr[i] = -1;
            } else {
                nextOfCurr[i] = currIndex[currChar - 'a'];
            }
            currIndex[currChar - 'a'] = i;
        }
        Arrays.fill(currIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currIndex[currChar - 'a'] == -1) {
                prevOfCurr[i] = -1;
            } else {
                prevOfCurr[i] = currIndex[currChar - 'a'];
            }
            currIndex[currChar - 'a'] = i;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                if (gap == 0 || gap == 1) {
                    dp[i][j] = gap + 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (nextOfCurr[i] > prevOfCurr[j]) {
                            dp[i][j] = (2 * dp[i + 1][j - 1] + 2) % MOD;
                        } else if (nextOfCurr[i] == prevOfCurr[j]) {
                            dp[i][j] = (2 * dp[i + 1][j - 1] + 1) % MOD;
                        } else {
                            dp[i][j] = (2 * dp[i + 1][j - 1] - dp[nextOfCurr[i] + 1][prevOfCurr[j] - 1]) % MOD;
                        }
                    } else {
                        dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]) % MOD;
                    }
                    dp[i][j] = (dp[i][j] + MOD) % MOD;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
