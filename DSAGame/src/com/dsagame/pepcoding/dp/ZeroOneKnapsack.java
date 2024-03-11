package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{2, 5, 1, 3, 4}, new int[]{15, 14, 10, 45, 30}, 7));
    }

    public static int maxWeight(int[] weight, int[] price, int limit) {
        int[][] dp = new int[weight.length + 1][limit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j - weight[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
