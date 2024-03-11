package com.dsagame.leetcode.dailychallenge.nov;

import java.util.Arrays;

public class Leetcode1685 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 3, 1, 4, 6, 1};


        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(new int[]{1, 4, 6, 8, 10})));
    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            prefix[i] = nums[i] + prefix[i - 1];
            suffix[j] = nums[j] + suffix[j + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = Math.abs((i + 1) * nums[i] - prefix[i]) + Math.abs((nums.length - i) * nums[i] - suffix[i]);
        }
        return res;
    }
}
