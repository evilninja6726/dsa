package com.dsagame.striver.atoz.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        });
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {
            while (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                i++;
            }
            list.add(intervals[i]);
        }
        System.out.println(list);
        return new int[1][1];
    }
}
