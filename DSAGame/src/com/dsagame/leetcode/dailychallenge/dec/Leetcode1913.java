package com.dsagame.leetcode.dailychallenge.dec;

public class Leetcode1913 {
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5, 6, 2, 7, 4}));
        System.out.println(maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8}));
        System.out.println(maxProductDifference(new int[]{1, 6, 7, 5, 2, 4, 10, 6, 4}));
        System.out.println(maxProductDifference(new int[]{1, 6, 7, 5, 2, 4, 10, 6, 4}));
    }

    public static int maxProductDifference(int[] nums) {
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE, firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
            if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            } else if (num < secondMin) {
                secondMin = num;
            }
        }
        return firstMax * secondMax - firstMin * secondMin;
    }
}
