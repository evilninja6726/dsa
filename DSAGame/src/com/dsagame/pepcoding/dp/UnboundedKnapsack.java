package com.dsagame.pepcoding.dp;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        System.out.println(maxWeight(new int[]{2, 5, 1, 3, 4}, new int[]{15, 14, 10, 45, 30}, 7));
    }

    public static int maxWeight(int[] weight, int[] price, int limit) {
        int[] dp = new int[limit + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < weight.length; j++) {
                if (i - weight[j] >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + price[j]);
                }
            }
        }
        return dp[limit];
    }
}
