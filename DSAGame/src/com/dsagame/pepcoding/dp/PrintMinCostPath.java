package com.dsagame.pepcoding.dp;

import java.util.ArrayDeque;
import java.util.Queue;


public class PrintMinCostPath {

    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 4, 2, 8, 2},
                {4, 3, 6, 5, 0, 4},
                {1, 2, 4, 1, 4, 6},
                {2, 0, 7, 3, 2, 2},
                {3, 1, 5, 9, 2, 4},
                {2, 7, 0, 8, 5, 1}
        };
        print(array);
    }

    public static void print(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + arr[i][j];
                }
            }
        }

        Queue<PrintHelper> queue = new ArrayDeque<>();
        queue.add(new PrintHelper(0, 0, arr[0][0], dp[0][0], ""));
        while (!queue.isEmpty()) {
            PrintHelper front = queue.poll();
            if (front.row == arr.length - 1 && front.column == arr[0].length - 1) {
                System.out.println(front.result);
            } else if (front.row == arr.length - 1) {
                queue.add(new PrintHelper(front.row, front.column + 1, arr[front.row][front.column + 1], dp[front.row][front.column + 1], front.result + 'H'));
            } else if (front.column == arr[0].length - 1) {
                queue.add(new PrintHelper(front.row + 1, front.column, arr[front.row + 1][front.column], dp[front.row + 1][front.column], front.result + 'V'));
            } else {
                if (dp[front.row + 1][front.column] == dp[front.row][front.column + 1]) {
                    queue.add(new PrintHelper(front.row, front.column + 1, arr[front.row][front.column + 1], dp[front.row][front.column + 1], front.result + 'H'));
                    queue.add(new PrintHelper(front.row + 1, front.column, arr[front.row + 1][front.column], dp[front.row + 1][front.column], front.result + 'V'));
                } else if (dp[front.row + 1][front.column] < dp[front.row][front.column + 1]) {
                    queue.add(new PrintHelper(front.row + 1, front.column, arr[front.row + 1][front.column], dp[front.row + 1][front.column], front.result + 'V'));
                } else {
                    queue.add(new PrintHelper(front.row, front.column + 1, arr[front.row][front.column + 1], dp[front.row][front.column + 1], front.result + 'H'));
                }
            }
        }
    }

    static class PrintHelper {
        int row;
        int column;
        int arrVal;
        int dpVal;
        String result;

        public PrintHelper(int row, int column, int arrVal, int dpVal, String result) {
            this.row = row;
            this.column = column;
            this.arrVal = arrVal;
            this.dpVal = dpVal;
            this.result = result;
        }
    }
}




