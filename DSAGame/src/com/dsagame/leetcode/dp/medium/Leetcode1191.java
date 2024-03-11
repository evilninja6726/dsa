package com.dsagame.leetcode.dp.medium;

import java.util.Arrays;

public class Leetcode1191 {
    public static void main(String[] args) {
        System.out.println(kConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        System.out.println(kConcatenationMaxSum(new int[]{1, 2}, 3));
        System.out.println(kConcatenationMaxSum(new int[]{-1, -2}, 5));
        System.out.println(kConcatenationMaxSum(new int[]{-5, 4, -4, -3, 5, -3}, 3));
        System.out.println(kConcatenationMaxSum(new int[]{-1}, 1));
    }

    public static int kConcatenationMaxSum(int[] arr, int k) {
        final int MOD = 1000000007;
        long sumOfArray = Arrays.stream(arr).sum();
        if (k == 1) {
            return Math.max((int) kadane(arr), 0);
        } else {
            int[] newArr = new int[arr.length * 2];
            int index = 0;
            for (int j = 0; j < 2; j++) {
                for (int x : arr) {
                    newArr[index++] = x;
                }
            }
            long newKadane = kadane(newArr);
            if (newKadane < 0) {
                return 0;
            } else if (sumOfArray < 0) {
                return (int) (newKadane % MOD);
            } else {
                return (int) ((newKadane + ((k - 2) * sumOfArray) % MOD) % MOD);
            }
        }
    }

    public static long kadane(int[] arr) {
        final int MOD = 1000000007;
        long res = arr[0];
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max + arr[i], arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
