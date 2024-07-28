package com.dsagame.striver.atoz.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumK {
    public static void main(String[] args) {

    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int res = 0;
        map.put(prefixSum, 1);
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                res += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
