package com.dsagame.striver.atoz.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarrayWithXor {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(4, 2, 2, 6, 4)), 6));
        System.out.println(solve(new ArrayList<>(Arrays.asList(5, 6, 7, 8, 9)), 5));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int prefixSum = 0;
        for (int i = 0; i < A.size(); i++) {
            prefixSum ^= A.get(i);
            if (map.containsKey(prefixSum ^ B)) {
                res += map.get(prefixSum ^ B);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return res;
    }
}
