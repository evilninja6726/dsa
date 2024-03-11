package com.dsagame.pepcoding.dp;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintPathWithMaxGold {

    public static void main(String[] args) {
        int[][] numbers = {
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };

        int[][] mine = {
                {3, 2, 5, 1},
                {2, 4, 6, 0},
                {5, 0, 1, 3},
                {9, 1, 5, 1}
        };

        print(mine);
    }

    public static void print(int[][] mine) {
        int[][] dp = new int[mine.length][mine[0].length];
        int max = Integer.MIN_VALUE;
        for (int j = mine[0].length - 1; j >= 0; j--) {
            for (int i = mine.length - 1; i >= 0; i--) {
                if (j == mine[0].length - 1) {
                    dp[i][j] = mine[i][j];
                } else if (i == 0) {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == mine.length - 1) {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
                }
                if (j == 0) {
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        Queue<PrintHelper> queue = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] == max) {
                queue.offer(new PrintHelper(i, 0, mine[i][0], dp[i][0], i + "-"));
            }
        }
        while (!queue.isEmpty()) {
            PrintHelper front = queue.poll();
            int nextVal = front.currMax - front.currVal;
            int i = front.row;
            int j = front.column;
            String res = front.result;
            if (front.column == dp[0].length - 1) {
                System.out.println(front.result);
            } else if (i == 0) {
                if (nextVal == dp[i][j + 1]) {
                    queue.offer(new PrintHelper(i, j + 1, mine[i][j + 1], nextVal, res + "H"));
                } else {
                    queue.offer(new PrintHelper(i + 1, j + 1, mine[i + 1][j + 1], nextVal, res + "D"));
                }
            } else if (front.row == dp.length - 1) {
                if (nextVal == dp[i - 1][j + 1]) {
                    queue.offer(new PrintHelper(i - 1, j + 1, mine[i - 1][j + 1], nextVal, res + "U"));
                } else {
                    queue.offer(new PrintHelper(i, j + 1, mine[i][j + 1], nextVal, res + "H"));
                }
            } else {
                if (nextVal == dp[i - 1][j + 1]) {
                    queue.offer(new PrintHelper(i - 1, j + 1, mine[i - 1][j + 1], nextVal, res + "U"));
                } else if (nextVal == dp[i][j + 1]) {
                    queue.offer(new PrintHelper(i, j + 1, mine[i][j + 1], nextVal, res + "H"));
                } else {
                    queue.offer(new PrintHelper(i + 1, j + 1, mine[i + 1][j + 1], nextVal, res + "D"));
                }
            }
        }
    }

    static class PrintHelper {
        int row;
        int column;
        int currVal;
        int currMax;
        String result;

        public PrintHelper(int row, int column, int currVal, int currMax, String result) {
            this.row = row;
            this.column = column;
            this.currVal = currVal;
            this.currMax = currMax;
            this.result = result;
        }
    }
}
