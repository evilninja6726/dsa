package com.dsagame.striver.atoz.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{10, 5, 2, 7, 1, 9}, 6, 15));
        System.out.println(lenOfLongSubarr(new int[]{-1, 2, 3}, 3, 6));
    }

    public static int lenOfLongSubarr(int[] A, int N, int K) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int res = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
            if (sum == K) {
                res = Math.max(res, i + 1);
            }
            int remaining = sum - K;
            if (prefixSumMap.containsKey(remaining)) {
                res = Math.max(res, i - prefixSumMap.get(remaining));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return res;
    }
}
