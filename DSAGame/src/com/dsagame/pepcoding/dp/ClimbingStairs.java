package com.dsagame.pepcoding.dp;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(countPathRec(10));
        System.out.println(countPathMem(10, new int[11]));
        System.out.println(countPathTab(10));
    }

    public static int countPathRec(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return countPathRec(n - 1) + countPathRec(n - 2) + countPathRec(n - 3);
    }

    public static int countPathMem(int n, int[] dp) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = countPathMem(n - 1, dp) + countPathMem(n - 2, dp) + countPathMem(n - 3, dp);
        return dp[n];
    }

    public static int countPathTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
