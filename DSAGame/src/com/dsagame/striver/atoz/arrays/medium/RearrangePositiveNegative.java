package com.dsagame.striver.atoz.arrays.medium;

import java.util.Arrays;

public class RearrangePositiveNegative {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }

    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pIndex = 0;
        int nIndex = 1;
        for (int num : nums) {
            if (num > 0) {
                res[pIndex] = num;
                pIndex += 2;
            } else {
                res[nIndex] = num;
                nIndex += 2;
            }
        }
        return res;
    }
}
