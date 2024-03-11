package com.dsagame.leetcode.dp.medium;

import java.util.Arrays;

public class Leetcode486 {
    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 2}));
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(predictTheWinner(new int[]{1, 5, 2, 4, 6}));
    }

    public static boolean predictTheWinner(int[] nums) {
        if (nums.length == 1 || nums.length == 2) {
            return true;
        }
        int totalSum = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][nums.length];
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = nums[i];
                } else if (gap == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    dp[i][j] = Math.max(nums[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]), nums[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]));
                }
            }
        }
        return dp[0][nums.length - 1] >= totalSum - dp[0][nums.length - 1];
    }
}
