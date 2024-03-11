package com.dsagame.leetcode.dp.medium;

public class Leetcode718 {
    public static void main(String[] args) {

    }

    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums2.length][nums1.length];
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if ((i == 0 || j == 0) && nums1[j] == nums2[i]) {
                    dp[i][j] = 1;
                } else if (nums1[j] == nums2[i]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
