package com.dsagame.practice;

import java.util.Arrays;
import java.util.List;

public class Lonest {
    public static void main(String[] args) {

    }

    public static int findLongestSubsequence(int N, List<Integer> A) {
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(j) < A.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
