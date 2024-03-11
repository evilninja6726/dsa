package com.dsagame.pepcoding.dp;

public class GoldMine {
    public static void main(String[] args) {
        int[][] array2D = {
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };

        System.out.println(goldMineTab(array2D));
    }

    public static int goldMineTab(int[][] mine) {
        int[][] dp = new int[mine.length][mine[0].length];
        for (int i = mine.length - 1; i >= 0; i--) {
            dp[i][mine[0].length - 1] = mine[i][mine[0].length - 1];
        }
        for (int j = mine[0].length - 2; j >= 0; j--) {
            for (int i = mine.length - 1; i >= 0; i--) {
                if (i == mine.length - 1) {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else if (i == 0) {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int[] arr : dp) {
            res = Math.max(res, arr[0]);
        }
        return res;
    }
}
