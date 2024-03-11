package com.dsagame.leetcode.dp.medium;

public class Leetcode96 {
    public static void main(String[] args) {

    }

    public static int numTrees(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (double) ((4 * i) + 2) / (i + 2);
        }
        return res;
    }
}
