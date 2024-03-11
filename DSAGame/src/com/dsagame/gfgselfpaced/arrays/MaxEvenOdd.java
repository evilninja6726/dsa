package com.dsagame.gfgselfpaced.arrays;

public class MaxEvenOdd {
    public static void main(String[] args) {
        System.out.println(maxEvenOdd(new int[]{10, 12, 14, 7, 8}));
    }

    public static int maxEvenOdd(int[] arr) {
        int res = 0;
        int maxCount = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                maxCount++;
                res = Math.max(res, maxCount);
            } else {
                maxCount = 1;
            }
        }
        return res;
    }
}
