package com.dsagame.leetcode.bit.med;

import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    public static void main(String[] args) {
        System.out.println(grayCode(3));
        System.out.println(grayCodeItr(3));
    }

    public static List<Integer> grayCode(int n) {
        if (n == 1) {
            return new ArrayList<>(List.of(0, 1));
        }
        List<Integer> prev = grayCode(n - 1);
        List<Integer> res = new ArrayList<>();
        for (Integer num : prev) {
            res.add((num << 1));
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            res.add((prev.get(i) << 1) + 1);
        }
        return res;
    }

    public static List<Integer> grayCodeItr(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
