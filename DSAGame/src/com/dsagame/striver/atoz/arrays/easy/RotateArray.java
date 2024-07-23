package com.dsagame.striver.atoz.arrays.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
    }

    public static void rotate(int[] nums, int k) {
        if (nums.length < 2 || k == 0 || k == nums.length) {
            return;
        }
        if (k > nums.length) {
            k %= nums.length;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
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
