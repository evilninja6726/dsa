package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class ClimbStairsWithMinMoves {
    public static void main(String[] args) {
        System.out.println(minMoviesRec(10, new int[]{1, 3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));
    }

    public static int minMoviesRec(int n, int[] jumps) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 1; i <= jumps[n]; i++) {
            sum += minMoviesRec(n - i, jumps);
            res = Math.min(res, sum);
        }
        return Math.min(res, sum);
    }

    public static int minMovesTab(int n, int[] jumps) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= jumps[i] && (i - j) >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j]);
            }
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i] += 1;
            }
        }
        return dp[n];
    }
}
