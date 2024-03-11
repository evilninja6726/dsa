package com.dsagame.gfgselfpaced.arrays;

import java.util.Arrays;

public class MaximumCircularSubArray {
    public static void main(String[] args) {
        System.out.println(maxCircularSubArray(new int[]{-3, -2, -3}));
        System.out.println(maxCircularSubArray(new int[]{5, -3, 5}));
        System.out.println(maxCircularSubArray(new int[]{1, -6, -7, 4}));
    }

    public static int maxCircularSubArray(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] res = minAndMaxSubArraySum(nums);
        return (res[1] < 0) ? res[1] : Math.max(res[1], sum - res[0]);
    }

    public static int[] minAndMaxSubArraySum(int[] arr) {
        int[] res = new int[2];
        res[0] = res[1] = arr[0];
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min + arr[i], arr[i]);
            res[0] = Math.min(res[0], min);
            max = Math.max(max + arr[i], arr[i]);
            res[1] = Math.max(res[1], max);
        }
        return res;
    }

}
