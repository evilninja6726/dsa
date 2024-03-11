package com.dsagame.pepcoding.dp;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintZeroOneKnapsack {

    public static void main(String[] args) {
        print(new int[]{2, 5, 1, 3, 4}, new int[]{15, 14, 10, 45, 30}, 7);
    }

    public static void print(int[] weight, int[] value, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j - weight[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        Queue<PrintHelper> queue = new ArrayDeque<>();
        queue.offer(new PrintHelper(dp.length - 1, dp[0].length - 1, ""));
        while (!queue.isEmpty()) {
            PrintHelper front = queue.poll();
            int i = front.row;
            int j = front.column;
            String res = front.result;
            if (i == 0 || j == 0) {
                System.out.println(res);
            } else {
                if (dp[i][j] == dp[i - 1][j]) {
                    queue.offer(new PrintHelper(i - 1, j, res));
                }
                if (dp[i][j] == value[i - 1] + dp[i - 1][j - weight[i - 1]]) {
                    queue.offer(new PrintHelper(i - 1, j - weight[i - 1], res + weight[i - 1] + " "));
                }
            }
        }
    }

    static class PrintHelper {
        int row;
        int column;
        String result;

        public PrintHelper(int row, int column, String result) {
            this.row = row;
            this.column = column;
            this.result = result;
        }
    }
}
