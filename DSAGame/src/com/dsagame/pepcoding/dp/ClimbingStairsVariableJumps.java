package com.dsagame.pepcoding.dp;

public class ClimbingStairsVariableJumps {
    public static void main(String[] args) {
        System.out.println(countPathRec(6, new int[]{1, 2, 3, 0, 2, 2, 3}));
        System.out.println(countPathMem(6, new int[]{1, 2, 3, 0, 2, 2, 3}, new int[7]));
        System.out.println(countPathTab(6, new int[]{1, 2, 3, 0, 2, 2, 3}));
    }

//    public static int countPathRec(int curr, int n, int[] jumps) {
//        if (curr == n) {
//            return 1;
//        } else if (curr > n) {
//            return 0;
//        }
//        int res = 0;
//        for (int i = 1; i <= jumps[n]; i++) {
//            res += countPathRec(n - 1, n - i, jumps);
//        }
//        return res;
//    }

    public static int countPathRec(int n, int[] jumps) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i <= jumps[n]; i++) {
            res += countPathRec(n - i, jumps);
        }
        return res;
    }

    public static int countPathMem(int n, int[] jumps, int[] dp) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 1; i <= jumps[n]; i++) {
            dp[n] += countPathMem(n - i, jumps, dp);
        }
        return dp[n];
    }

    public static int countPathTab(int n, int[] jumps) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= jumps[i] && (i - j) >= 0; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }
}
