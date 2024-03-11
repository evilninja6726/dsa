package com.dsagame.leetcode.hashing.medium;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1865 {
    public static void main(String[] args) {

    }
}

class FindSumPairs {
    Map<Integer, Integer> map;
    int[] nums1;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int x : nums2) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        if (map.get(oldVal) == 1) {
            map.remove(oldVal);
        } else {
            map.put(oldVal, map.get(oldVal) - 1);
        }
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int res = 0;
        for (int x : nums1) {
            if (map.containsKey(tot - x)) {
                res += map.get(tot - x);
            }
        }
        return res;
    }
}
