package com.dsagame.pepcoding.dp;

public class CoinChangePermutation {
    public static void main(String[] args) {
        System.out.println(coinChangePermutation(new int[]{2, 3, 5, 6}, 10));
    }

    public static int coinChangePermutation(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            for (int coin : coins) {
                if (currAmount >= coin) {
                    dp[currAmount] += (dp[currAmount - coin]);
                }
            }
        }
        return dp[amount];
    }
}
