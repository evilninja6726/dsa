package com.dsagame.pepcoding.dp;

public class MaxSubArrayWithMinSizeK {
    public static void main(String[] args) {
        //[-2, 1, -2, 4, 3, 5, 6, 1, 5]
        //System.out.println(Arrays.toString(kadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
        System.out.println(maxSumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 3));
        System.out.println(maxSumSubArray(new int[]{2, 3, 1, -7, 6, -5, -4, 4, 3, 3, 2, -9, -5, 6, 1, 2, 1, 1}, 4));
    }

    public static int maxSumSubArray(int[] arr, int k) {
        if (k == 1) {
            return kadane(arr)[arr.length - 1];
        }
        int[] dp = new int[arr.length];
        int[] kadaneArray = kadane(arr);
        int window = 0;
        for (int i = 0; i < k; i++) {
            window += arr[i];
        }
        int res = Integer.MIN_VALUE;
        for (int i = k; i < arr.length; i++) {
            window = window - arr[i - k] + arr[i];
            res = Math.max(res, Math.max(window, window + kadaneArray[i - k]));
        }
        return res;
    }

    public static int[] kadane(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = Math.max(res[i - 1] + arr[i], arr[i]);
        }
        return res;
    }
}
