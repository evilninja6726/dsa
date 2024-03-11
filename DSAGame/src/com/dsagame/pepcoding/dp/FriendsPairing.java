package com.dsagame.pepcoding.dp;

public class FriendsPairing {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(friendsPairing(i));
        }
    }

    public static long friendsPairing(int n) {
        long[] dp = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1 || i == 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + ((i - 1) * dp[i - 2]);
            }
        }
        return dp[n];
    }
}
