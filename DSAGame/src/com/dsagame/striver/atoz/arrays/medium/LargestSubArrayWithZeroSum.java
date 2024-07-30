package com.dsagame.striver.atoz.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{15, -2, 2, -8, 1, 7, 10, 23}, 8));
    }

    static int maxLen(int arr[], int n) {
        int prefixSum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == 0) {
                res = Math.max(res, i + 1);
            }
            if (map.containsKey(prefixSum)) {
                res = Math.max(res, i - map.get(prefixSum));
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return res;
    }
}
