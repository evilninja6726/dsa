package com.dsagame.leetcode.queue.hard;

public class Leetcode862 {
    public static void main(String[] args) {

    }

    public static int shortestSubarray(int[] nums, int k) {
        if (nums.length == 1 && k == 1) {
            return 1;
        } else if (nums.length == 1) {
            return -1;
        }
        int res = 0;
        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k) {
                res = Math.min(res, i - j + 1);
            } else {
                j = i;
            }
        }
        return res;
    }
}
