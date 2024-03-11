package com.dsagame.leetcode.dailychallenge.dec;

public class Leetcode1464 {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{10, 2, 5, 2}));
    }

    public static int maxProduct(int[] nums) {
        int firstLargest = nums[0], secondLargest = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = nums[i];
            } else if (nums[i] == firstLargest || nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        return (firstLargest - 1) * (secondLargest - 1);
    }
}
