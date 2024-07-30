package com.dsagame.striver.atoz.arrays.medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSumTwoPointer(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> uniqueResults = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (set.contains(-sum)) {
                    List<Integer> triplets = Arrays.asList(nums[i], -sum, nums[j]);
                    Collections.sort(triplets);
                    uniqueResults.add(triplets);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(uniqueResults);
    }

    public static List<List<Integer>> threeSumTwoPointer(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if (i == 0 || nums[i] != nums[i - 1]) {
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else {
                        if (nums[i] + nums[j] + nums[k] > 0) {
                            k--;
                        } else {
                            j++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
