package com.dsagame.leetcode.dailychallenge.feb;

public class Leetcode45 {
    static int res = 0;

    public static void main(String[] args) {
        //  System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        //System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        //return helper(nums, 0);
//        int[] dp = new int[nums.length + 1];
//        Arrays.fill(dp, 1001);
//        return helperMem(nums, 0, dp);

        Integer[] dp = new Integer[nums.length];
        dp[dp.length - 1] = 0;
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= dp[i] && i + j < nums.length; j++) {
                if (dp[j + i] != null) {
                    dp[i] = Math.min(dp[i], dp[j + i]) + 1;
                }
            }
        }
        return dp[0];
    }

    public static int helper(int[] arr, int index) {
        if (index == arr.length - 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[index]; i++) {
            if (i + index < arr.length) {
                int nextCall = helper(arr, index + i) + 1;
                res = Math.min(res, nextCall);
            }
        }
        return res;
    }

    public static int helperMem(int[] arr, int index, int[] dp) {
        if (index == arr.length - 1) {
            return 0;
        }
        if (dp[index] != 1001) {
            return dp[index];
        }
        for (int i = 1; i <= arr[index]; i++) {
            if (i + index < arr.length) {
                int nextCall = helperMem(arr, index + i, dp) + 1;
                dp[index] = Math.min(nextCall, dp[index]);
            }
        }
        return dp[index];
    }


}
