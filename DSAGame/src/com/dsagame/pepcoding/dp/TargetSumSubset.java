package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class TargetSumSubset {
    public static void main(String[] args) {
        System.out.println(targetSumSubset(new int[]{4, 2, 7, 1, 3}, 10));
    }

    public static boolean targetSumSubset(int[] arr, int target) {
        boolean[][] dp = new boolean[arr.length + 1][target + 1];
//        for (int i = 0; i < dp.length; i++) {
//            dp[i][0] = true;
//        }
//        for (int i = 1; i < dp.length; i++) {
//            dp[i][arr[i - 1]] = true;
//        }
        for (boolean[] temp : dp) {
            System.out.println(Arrays.toString(temp));
        }
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
                if (i != 0) {
                    dp[i][arr[i - 1]] = true;
                }
                if (i != 0 && dp[i - 1][j]) {
                    dp[i][j] = true;
                    if (j + arr[i - 1] < dp[0].length) {
                        dp[i][j + arr[i - 1]] = true;
                    }
                }
            }
        }
        for (boolean[] temp : dp) {
            System.out.println(Arrays.toString(temp));
        }
        return dp[arr.length][arr.length];
    }
}
