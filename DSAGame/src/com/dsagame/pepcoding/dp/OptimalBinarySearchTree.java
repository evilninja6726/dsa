package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(minSearchCost(new int[]{10, 20, 30, 40}, new int[]{1, 2, 3, 4}));
        System.out.println(minSearchCost(new int[]{10, 20, 30, 40}, new int[]{3, 1, 2, 1}));
    }

    public static int sum(int[] arr, int i, int j) {
        return Arrays.stream(arr, i, j + 1).sum();
    }

    public static int minSearchCost(int[] nodes, int[] frequency) {
        int[][] dp = new int[nodes.length][nodes.length];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                int increaseLevelCost = sum(frequency, i, j);
                if (gap == 0) {
                    dp[i][j] = frequency[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.min(dp[i][j - 1] + 2 * dp[i + 1][j], dp[i + 1][j] + 2 * dp[i][j - 1]);
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        if (k == 0) {
                            min = Math.min(min, dp[k + 1][j] + increaseLevelCost);
                        } else if (k == dp[0].length - 1) {
                            min = Math.min(min, dp[i][k] + increaseLevelCost);
                        } else {
                            min = Math.min(min, dp[i][k - 1] + dp[k + 1][j] + increaseLevelCost);
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][dp[0].length - 1];
    }
}
