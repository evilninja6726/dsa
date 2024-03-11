package com.dsagame.leetcode.bit.med;

import java.util.*;

public class Leetcode90 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> localList = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    localList.add(nums[j]);
                }
            }
            res.add(localList);
        }
        return new ArrayList<>(res);
    }
}
