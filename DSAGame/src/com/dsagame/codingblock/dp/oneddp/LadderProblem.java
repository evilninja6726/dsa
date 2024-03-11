package com.dsagame.codingblock.dp.oneddp;

public class LadderProblem {
    public static void main(String[] args) {
        System.out.println(ladderRec(4, 3));
        System.out.println(ladderMem(4, 3, new int[5]));
        System.out.println(ladderTab(4, 3));
        System.out.println(ladderTabMoreEff(4, 3));
    }

    public static int ladderRec(int n, int k) {
        if (n == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                res += ladderRec(n - i, k);
            }
        }
        return res;
    }

    public static int ladderMem(int n, int k, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int res = 0;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                res += ladderMem(n - i, k, dp);
            }
        }
        dp[n] = res;
        return dp[n];
    }

    public static int ladderTab(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

    public static int ladderTabMoreEff(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= k; i++) {
            dp[i] = 2 * dp[i - 1];
        }
        for (int i = k + 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1] - dp[n - i];
        }
        return dp[n];
    }
}
