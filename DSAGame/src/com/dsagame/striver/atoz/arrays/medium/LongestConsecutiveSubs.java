package com.dsagame.striver.atoz.arrays.medium;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LongestConsecutiveSubs {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{

        }));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = IntStream.of(nums).boxed().collect(Collectors.toSet());
        int res = 1;
        for (int num : nums) {
            int max = 1;
            int curr = num;
            if (set.contains(curr - 1)) {
                continue;
            }
            while (set.contains(curr + 1)) {
                max++;
                curr++;
            }
            res = Math.max(res, max);
        }
        return res;
    }
}
