package com.dsagame.pepcoding.dp;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintMinJumps {
    public static void main(String[] args) {
        printMinJumps(new int[]{3, 3, 0, 2, 1, 2, 4, 2, 0, 0});
    }

    public static void printMinJumps(int[] nums) {
        Integer[] dp = new Integer[nums.length];
        dp[dp.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
                if (dp[j] != null) {
                    min = Math.min(min, dp[j]);
                    dp[i] = 1 + min;
                }
            }
        }
        Queue<PrintHelper> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(new PrintHelper(0, nums[0], dp[0], 0 + ""));
        while (!arrayDeque.isEmpty()) {
            PrintHelper first = arrayDeque.remove();
            if (first.allowedJumps == 0) {
                System.out.println(first.result);
            }
            for (int j = first.currIndex + 1; j <= first.currIndex + first.currJumps && j < nums.length; j++) {
                if (dp[j] != null && dp[j] == first.allowedJumps - 1) {
                    arrayDeque.add(new PrintHelper(j, nums[j], first.allowedJumps - 1, first.result + "-" + j));
                }
            }
        }
    }
}


class PrintHelper {
    int currIndex;
    int currJumps;
    int allowedJumps;
    String result;

    public PrintHelper(int currIndex, int currJumps, int allowedJumps, String result) {
        this.currIndex = currIndex;
        this.currJumps = currJumps;
        this.allowedJumps = allowedJumps;
        this.result = result;
    }
}
