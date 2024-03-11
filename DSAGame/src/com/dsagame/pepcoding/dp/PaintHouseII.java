package com.dsagame.pepcoding.dp;

public class PaintHouseII {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5, 7},
                {5, 8, 4},
                {3, 2, 9},
                {1, 2, 4}
        };
        System.out.println(minCost(arr));
        System.out.println(minCostEff(arr));
        System.out.println(minCostMostEff(arr));
    }

    public static int minCost(int[][] cost) {
        int[][] dp = new int[cost.length + 1][cost[0].length];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = cost[i - 1][j] + minCostForPrev(dp[i - 1], j);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }
        return res;
    }

    public static int minCostForPrev(int[] arr, int index) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                min = Math.min(min, arr[i]);
            }
        }
        return min;
    }

    public static int minCostEff(int[][] cost) {
        int[][] dp = new int[cost.length + 1][cost[0].length];
        for (int i = 1; i < dp.length; i++) {
            int[] temp = firstAndSecondMin(dp[i - 1]);
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i - 1][j] == temp[0]) {
                    dp[i][j] = cost[i - 1][j] + temp[1];
                } else {
                    dp[i][j] = cost[i - 1][j] + temp[0];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }
        return res;
    }

    public static int[] firstAndSecondMin(int[] arr) {
        int[] res = new int[2];
        int firstMin = arr[0];
        int secondMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < firstMin) {
                secondMin = firstMin;
                firstMin = arr[i];
            } else if (arr[i] == firstMin) {
                secondMin = firstMin;
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }
        res[0] = firstMin;
        res[1] = secondMin;
        return res;
    }

    public static int minCostMostEff(int[][] cost) {
        int[][] dp = new int[cost.length + 1][cost[0].length];
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int j = 0; j < cost[0].length; j++) {
            dp[1][j] = cost[0][j];
            if (cost[0][j] <= firstMin) {
                secondMin = firstMin;
                firstMin = cost[0][j];
            } else if (cost[0][j] <= secondMin) {
                secondMin = cost[0][j];
            }
        }
        for (int i = 2; i < dp.length; i++) {
            int newFirstMin = Integer.MAX_VALUE;
            int newSecondMin = Integer.MAX_VALUE;
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i - 1][j] == firstMin) {
                    dp[i][j] = secondMin + cost[i - 1][j];
                } else {
                    dp[i][j] = firstMin + cost[i - 1][j];
                }
                if (dp[i][j] <= newFirstMin) {
                    newSecondMin = newFirstMin;
                    newFirstMin = dp[i][j];
                } else if (dp[i][j] <= newSecondMin) {
                    newSecondMin = dp[i][j];
                }
            }
            firstMin = newFirstMin;
            secondMin = newSecondMin;
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[0].length; j++) {
            res = Math.min(res, dp[dp.length - 1][j]);
        }
        return res;
    }
}
