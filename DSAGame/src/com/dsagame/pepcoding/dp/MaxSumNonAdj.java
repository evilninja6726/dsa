package com.dsagame.pepcoding.dp;

public class MaxSumNonAdj {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{5, 10, 10, 100, 5, 6}));
        System.out.println(robEff(new int[]{5, 10, 10, 100, 5, 6}));
        System.out.println(rob(new int[]{2, 1, 1, 2}));
    }

    public static int rob(int[] nums) {
        int[][] dp = new int[2][nums.length + 1];
        int max = Integer.MIN_VALUE;
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    dp[i][j] = nums[j - 1] + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static int robEff(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int inc = 0;
        int exc = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            int temp = inc;
            inc = nums[i - 1] + exc;
            exc = Math.max(exc, temp);
            res = Math.max(res, Math.max(inc, exc));
        }
        return res;
    }
}
