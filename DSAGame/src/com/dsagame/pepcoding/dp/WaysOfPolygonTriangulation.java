package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class WaysOfPolygonTriangulation {
    public static void main(String[] args) {
        System.out.println(ways(7));
        System.out.println(waysEff(7));
    }

    public static int ways(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        dp[2] = dp[3] = 1;
        for (int i = 4; i <= n; i++) {
            for (int j = 0; j < i - 2; j++) {
                dp[i] += dp[i - j - 1] * dp[j + 2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static int waysEff(int n) {
        n -= 2;
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (double) ((4 * i) + 2) / (i + 2);
        }
        return res;
    }
}
