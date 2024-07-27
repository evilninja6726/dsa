package com.dsagame.striver.atoz.arrays.medium;

import java.util.Arrays;

public class NextPerm {
    public static void main(String[] args) {
        nextPermutation(new int[]{2, 1, 5, 4, 3, 0, 0});
    }

    public static void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                nums[i] ^= nums[index];
                nums[index] ^= nums[i];
                nums[i] ^= nums[index];
                break;
            }
        }
        reverse(nums, index + 1, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i++] ^= arr[j--];
        }
    }
}
