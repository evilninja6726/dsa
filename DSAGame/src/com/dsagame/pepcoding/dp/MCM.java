package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        System.out.println(mcm(new int[]{40, 20, 30, 10, 30}));
    }

    public static int mcm(int[] arr) {
        int[][] dp = new int[arr.length - 1][arr.length - 1];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp.length; i++, j++) {
                if (gap == 1) {
                    dp[i][j] = arr[i] * arr[j] * arr[j + 1];
                } else if (gap != 0) {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int currVal = dp[i][k] + dp[k + 1][j] + (arr[i] * arr[k + 1] * arr[j + 1]);
                        System.out.println(currVal);
                        min = Math.min(min, currVal);
                    }
                    dp[i][j] = min;
                }
            }
        }
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[0][dp[0].length - 1];
    }
}
