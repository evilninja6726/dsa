package com.dsagame.pepcoding.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
    public static void main(String[] args) {
        int[][] pairs = {
                {17, 5},
                {26, 18},
                {25, 34},
                {48, 84},
                {63, 72},
                {42, 86},
                {9, 55},
                {4, 70},
                {21, 45},
                {68, 76},
                {58, 51}
        };
        System.out.println(maxEnvelopes(pairs));
    }

    public static int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i][1] > arr[j][1] && arr[i][0] > arr[j][0]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
