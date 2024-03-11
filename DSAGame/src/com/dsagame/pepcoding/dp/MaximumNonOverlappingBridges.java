package com.dsagame.pepcoding.dp;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumNonOverlappingBridges {
    public static void main(String[] args) {
        int[][] pairs = {
                {10, 20},
                {2, 7},
                {8, 15},
                {17, 3},
                {21, 40},
                {50, 4},
                {41, 57},
                {60, 80},
                {80, 90},
                {1, 30}
        };
        System.out.println(maxBridges(pairs));
        int[][] arr = new int[][]{
                {1, 1},
                {2, 2}, {
                2, 3
        }
        };
        System.out.println(maxBridges(arr));
    }

    public static int maxBridges(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[i][1] > intervals[j][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
