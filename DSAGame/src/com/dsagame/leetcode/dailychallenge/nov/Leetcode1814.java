package com.dsagame.leetcode.dailychallenge.nov;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1814 {
    public static void main(String[] args) {
        System.out.println(countNicePairs(new int[]{13, 10, 35, 24, 76}));
        System.out.println(countNicePairs(new int[]{42, 11, 1, 97}));

    }

    public static int countNicePairs(int[] nums) {
        int res = 0;
        int mod = 10000007;
        Map<Integer, Integer> freqOfDiff = new HashMap<>();
        for (int x : nums) {
            int curr = Math.abs(x - rev(x));
            freqOfDiff.put(curr, freqOfDiff.getOrDefault(curr, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> map : freqOfDiff.entrySet()) {
            int n = map.getValue();
            res = (res % mod + (n * (n - 1)) / 2) % mod;
        }
        return res;
    }

    public static int rev(int n) {
        int res = 0;
        while (n != 0) {
            res *= 10;
            int rem = n % 10;
            res += rem;
            n /= 10;
        }
        return res;
    }
}
