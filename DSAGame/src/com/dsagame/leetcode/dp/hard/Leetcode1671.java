package com.dsagame.leetcode.dp.hard;

import java.util.Arrays;

public class Leetcode1671 {
    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80, 1}));
        System.out.println(minimumMountainRemovals(new int[]{9, 8, 1, 7, 6, 5, 4, 3, 2, 1}));
    }

    public static int minimumMountainRemovals(int[] nums) {
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];
        lis[0] = lds[lds.length - 1] = 1;
        int res = 0;
        for (int i = 1, j = lds.length - 2; i < lis.length && j >= 0; i++, j--) {
            int lisMax = 0;
            int ldsMax = 0;
            for (int k = i - 1, l = j + 1; k >= 0 && l < lds.length; k--, l++) {
                if (nums[i] > nums[k]) {
                    lisMax = Math.max(lisMax, lis[k]);
                }
                if (nums[j] > nums[l]) {
                    ldsMax = Math.max(ldsMax, lds[l]);
                }
            }
            lis[i] = lisMax + 1;
            lds[j] = ldsMax + 1;
        }
        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(lds));
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] != 1 && lds[i] != 1) {
                res = Math.max(res, lis[i] + lds[i] - 1);
            }
        }
        return res;
    }
}
