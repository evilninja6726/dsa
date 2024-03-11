package com.dsagame.gfgselfpaced.arrays;

public class MaxDiff {
    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{2, 3, 10, 6, 4, 8, 1}));
    }

    public static int maxDiff(int[] arr) {
        int res = 0;
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < max) {
                res = Math.max(res, max - arr[i]);
            } else {
                max = arr[i];
            }
        }
        return res;
    }
}
