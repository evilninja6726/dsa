package com.dsagame.leetcode.contest.biweekly94;

public class Leetcode6273 {
    public static void main(String[] args) {
        System.out.println(captureForts(new int[]{1, 0, 0, -1, 0, 1}));
    }

    public static int captureForts(int[] forts) {
        int res = 0;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1) {
                int leftMax = 0;
                int rightMax = 0;
                int j = i - 1;
                while (j >= 0 && forts[j] == 0) {
                    leftMax++;
                    j--;
                }
                if (j == -1 || (j >= 0 && (forts[j] == 0 || forts[j] == 1))) {
                    leftMax = 0;
                }
                j = i + 1;
                while (j < forts.length && forts[j] == 0) {
                    rightMax++;
                    j++;
                }
                if (j == forts.length || (j < forts.length && (forts[j] == 0 || forts[j] == 1))) {
                    rightMax = 0;
                }
                res = Math.max(res, Math.max(leftMax, rightMax));
            }
        }
        return res;
    }
}
