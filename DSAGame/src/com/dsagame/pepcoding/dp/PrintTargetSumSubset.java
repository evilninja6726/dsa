package com.dsagame.pepcoding.dp;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintTargetSumSubset {

    public static void main(String[] args) {
        print(new int[]{4, 2, 7, 1, 3}, 10);
    }

    public static void print(int[] arr, int k) {
        boolean[][] dp = new boolean[arr.length + 1][k + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j] || (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]])) {
                    dp[i][j] = true;
                }
            }
        }
        Queue<PrintHelper> queue = new ArrayDeque<>();
        queue.offer(new PrintHelper(dp.length - 1, dp[0].length - 1, ""));
        System.out.println(queue.size());
        while (!queue.isEmpty()) {
            PrintHelper front = queue.poll();
            int i = front.row;
            int j = front.column;
            String res = front.result;
            if (i == 0 || j == 0) {
                System.out.println(res);
            } else {
                if (dp[i - 1][j]) {
                    queue.offer(new PrintHelper(i - 1, j, res));
                }
                if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]]) {
                    queue.offer(new PrintHelper(i - 1, j - arr[i - 1], (i - 1) + " " + res));
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
