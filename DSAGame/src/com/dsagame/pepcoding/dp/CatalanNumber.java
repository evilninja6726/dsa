package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class CatalanNumber {
    public static void main(String[] args) {
        System.out.println(catalanNumber(10));
        System.out.println(catalanNumberEff(4));
    }

    public static int catalanNumber(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static int catalanNumberEff(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= ((double) (4 * i + 2) / (i + 2));
        }
        return res;
    }
}
