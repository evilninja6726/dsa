package com.dsagame.pepcoding.dp;

public class PaintHouse {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 5, 3, 1},
                {5, 8, 2, 2},
                {7, 4, 9, 4}
        };
        System.out.println(cost(arr));
        System.out.println(costEff(arr));
    }

    public static int cost(int[][] cost) {
        int[][] dp = new int[cost.length][cost[0].length + 1];
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 0; i < dp.length; i++) {
                if (i == 0) {
                    dp[i][j] = cost[i][j - 1] + Math.min(dp[i + 1][j - 1], dp[i + 2][j - 1]);
                } else if (i == 1) {
                    dp[i][j] = cost[i][j - 1] + Math.min(dp[i - 1][j - 1], dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = cost[i][j - 1] + Math.min(dp[i - 1][j - 1], dp[i - 2][j - 1]);
                }
            }
        }
        return Math.min(dp[0][cost[0].length], Math.min(dp[1][cost[0].length], dp[2][cost[0].length]));
    }

    public static int costEff(int[][] cost) {
        int red = 0;
        int blue = 0;
        int green = 0;
        for (int j = 0; j < cost[0].length; j++) {
            int temp1 = red;
            red = cost[0][j] + Math.min(blue, green);
            int temp2 = blue;
            blue = cost[1][j] + Math.min(temp1, green);
            green = cost[2][j] + Math.min(temp1, temp2);
        }
        return Math.min(red, Math.min(blue, green));
    }
}
