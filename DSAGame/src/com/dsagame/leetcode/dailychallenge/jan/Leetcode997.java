package com.dsagame.leetcode.dailychallenge.jan;

public class Leetcode997 {
    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
    }

    public static int findJudge(int n, int[][] trust) {
        if (n == 1) {
            return 1;
        }
        int[] trustCount = new int[n + 1];
        for (int[] trustPair : trust) {
            trustCount[trustPair[0]]--;
            trustCount[trustPair[1]]++;
        }
        for (int i = 0; i < trustCount.length; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
