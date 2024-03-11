package com.dsagame.gfgextras.arrays;

import java.util.ArrayList;

public class MaxSubArraySumOfSizeK {
    public static void main(String[] args) {

    }

    public static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
        int i = 0;
        int j = 0;
        long res = Long.MIN_VALUE;
        long maxSum = 0;
        while (j < N) {
            maxSum += Arr.get(j);
            if (j++ == i + K - 1) {
                res = Math.max(res, maxSum);
                maxSum -= Arr.get(i++);
            }
        }
        return res;
    }
}
