package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class RodCuttingMaxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(maxProfitEff(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
    }

    public static int maxProfit(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[1] = arr[0];
        for (int i = 2; i < dp.length; i++) {
            for (int j = i - 1, k = 0; j >= 0 && k < dp.length; j--, k++) {
                dp[i] = Math.max(dp[i], arr[j] + dp[k]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length];
    }

    public static int maxProfitEff(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[1] = arr[0];
        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j <= (i / 2); j++) {
                dp[i] = Math.max(dp[i], Math.max(arr[i - 1], dp[i - j] + dp[j]));
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[arr.length];
    }
}
