package com.dsagame.pepcoding.dp;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintLIS {

    public static void main(String[] args) {
        // print(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        //print(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 1});
        print(new int[]{10, 22, 43, 33, 21, 50, 41, 60, 59, 3});
    }

    public static void print(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            res = Math.max(res, dp[i]);
        }
        Queue<PrintHelper> queue = new ArrayDeque<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == res) {
                queue.offer(new PrintHelper(i, arr[i], arr[i] + ""));
            }
        }
        while (!queue.isEmpty()) {
            PrintHelper front = queue.poll();
            int idx = front.idx;
            int num = front.num;
            String result = front.result;
            if (idx == 0) {
                System.out.println(result);
            } else {
                for (int i = idx - 1; i >= 0; i--) {
                    if (dp[idx] - 1 == dp[i]) {
                        queue.offer(new PrintHelper(i, arr[i], arr[i] + " " + result));
                    }
                }
            }
        }
    }

    static class PrintHelper {
        int idx;
        int num;
        String result;

        public PrintHelper(int idx, int num, String result) {
            this.idx = idx;
            this.num = num;
            this.result = result;
        }
    }
}
