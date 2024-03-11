package com.dsagame.codingblock.dp.quickstart;

public class MinCoinChange {
    public static void main(String[] args) {
        System.out.println(minCoinRec(15, new int[]{7, 10, 1}));
        System.out.println(minCoinMem(15, new int[]{7, 10, 1}, new int[16]));
        System.out.println(minCoinTab(15, new int[]{7, 10, 1}));
        System.out.println(minCoinTab(11, new int[]{1, 2, 5}));

        /*coins =
[186,419,83,408]
amount =
6249*/
        System.out.println(minCoinTab(6349, new int[]{186, 419, 83, 408}));
        System.out.println(minCoinTab(6349, new int[]{83, 186, 408, 419}));
    }

    public static int minCoinRec(int n, int[] coins) {
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            int nextCall = 0;
            if (n - coinValue >= 0) {
                nextCall = 1 + minCoinRec(n - coinValue, coins);
                res = Math.min(res, nextCall);
            }
        }
        return res;
    }

    public static int minCoinMem(int n, int[] coins, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int res = Integer.MAX_VALUE;
        for (int coinValue : coins) {
            if (n - coinValue >= 0) {
                int nextCall = 1 + minCoinMem(n - coinValue, coins, dp);
                res = Math.min(res, nextCall);
            }
        }
        dp[n] = res;
        return dp[n];
    }

    public static int minCoinTab(int n, int[] coins) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coinValue : coins) {
                if (i - coinValue >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coinValue]);
                }
            }
        }
        return dp[n];
    }
}
