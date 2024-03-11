package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class CountDistinctSubs {
    public static void main(String[] args) {
        System.out.println(count("abcbac"));
    }

    public static int count(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        int[] prevOcc = new int[26];
        Arrays.fill(prevOcc, -1);
        for (int i = 1; i < dp.length; i++) {
            char currChar = s.charAt(i - 1);
            if (prevOcc[currChar - 'a'] != -1) {
                dp[i] = 2 * dp[i - 1] - dp[prevOcc[currChar - 'a']];
            } else {
                dp[i] = 2 * dp[i - 1];
            }
            prevOcc[currChar - 'a'] = i - 1;
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
