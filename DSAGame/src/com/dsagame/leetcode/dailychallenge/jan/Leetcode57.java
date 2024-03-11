package com.dsagame.leetcode.dailychallenge.jan;

import java.util.ArrayList;
import java.util.Collections;

public class Leetcode57 {
    public static void main(String[] args) {

    }


    // Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8],            [1,12]


    /*
    intervals =
[[3,5],[12,15]]
newInterval =
[6,6]
149 / 156 testcases passed
Output
[[3,5],[6,15],[12,15]]
Expected
[[3,5],[6,6],[12,15]]
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            list.add(newInterval);
        } else if (newInterval[1] < intervals[0][0]) {
            list.add(newInterval);
            Collections.addAll(list, intervals);
        } else if (newInterval[0] > intervals[intervals.length - 1][1]) {
            Collections.addAll(list, intervals);
            list.add(newInterval);
        } else {
            int i = 0;
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                list.add(intervals[i++]);
            }
            int start = Math.min(newInterval[0], intervals[i][0]);
            int end = (newInterval[1] < intervals[i][0]) ? newInterval[1] : Math.max(newInterval[1], intervals[i][1]);
            while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
                end = Math.max(intervals[i][1], newInterval[1]);
                i++;
            }
            list.add(new int[]{start, end});
            while (i < intervals.length) {
                list.add(intervals[i++]);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}
