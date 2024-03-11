package com.dsagame.leetcode.contest.biweekly97;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode2553 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[]{13, 25, 83, 77})));
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            List<Integer> individualList = new ArrayList<>();
            helper(num, individualList);
            list.addAll(individualList);
        }
        int[] res = new int[list.size()];
        int i = 0;
        for (int x : list) {
            res[i++] = x;
        }
        return res;
    }

    public static void helper(int n, List<Integer> res) {
        if (n == 0) {
            return;
        }
        int mod = n % 10;
        helper(n / 10, res);
        res.add(mod);
    }
}
