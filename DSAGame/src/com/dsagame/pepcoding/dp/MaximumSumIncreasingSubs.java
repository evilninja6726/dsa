package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class MaximumSumIncreasingSubs {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 1}));
        System.out.println(maxSum(new int[]{10, 22, 43, 33, 21, 50, 41, 60, 59, 3}));
    }

    public static int maxSum(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            int max = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j] + arr[i]);
                }
            }
            dp[i] = max;
            res = Math.max(res, max);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
