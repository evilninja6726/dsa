package com.dsagame.leetcode.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode376 {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }

    //wrong
    public static int wiggleMaxLength(int[] nums) {
        int[] wiggle = new int[nums.length - 1];
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            wiggle[i - 1] = nums[i] - nums[i - 1];
        }
        //System.out.println(Arrays.toString(wiggle));
        int i;
        int res = 0;
        boolean isPrevPos = false;
        for (i = 0; i < wiggle.length; i++) {
            if (wiggle[i] > 0) {
                isPrevPos = true;
                break;
            }
        }
        while (i < wiggle.length) {
            if (isPrevPos) {
                if (wiggle[i] < 0) {
                    isPrevPos = false;
                    res++;
                }
            } else {
                if (wiggle[i] > 0) {
                    isPrevPos = true;
                    res++;
                }
            }
            i++;
        }
        return res + 2;
    }
}
