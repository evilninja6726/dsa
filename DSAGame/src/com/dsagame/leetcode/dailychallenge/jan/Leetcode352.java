package com.dsagame.leetcode.dailychallenge.jan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Leetcode352 {
    public static void main(String[] args) {

        //[[],[6],[],[6],[],[0],[],[4],[],[8],[],[7],[],[6],[],[4],[],[7],[],[5],[]]
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(6);      // arr = [1]
        summaryRanges.getIntervals(); // return [[1, 1]]
        summaryRanges.addNum(6);      // arr = [1, 3]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(0);      // arr = [1, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(4);      // arr = [1, 2, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(8);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
        summaryRanges.addNum(7);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
        summaryRanges.addNum(4);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
        summaryRanges.addNum(7);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
        summaryRanges.addNum(5);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
        System.out.println(summaryRanges.map);
    }
}

/* SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // return [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // return [[1, 3], [6, 7]] */

class SummaryRanges {
    Map<Integer, Integer> map;

    public SummaryRanges() {
        map = new HashMap<>();
    }

    public void addNum(int value) {
        if (map.isEmpty()) {
            map.put(value, value);
        } else if (map.containsKey(value + 1)) {
            int j = map.get(value + 1);
            if (map.containsKey(value - 1)) {
                int i = value - 1;
                map.remove(i);
                map.remove(value + 1);
                map.put(i, j);
            } else if (map.containsValue(value - 1)) {
                int i = findKey(value - 1, map);
                map.remove(i);
                map.remove(value + 1);
                map.put(i, j);
            } else {
                map.remove(value + 1);
                map.put(value, j);
            }
        } else if (map.containsKey(value - 1)) {
            int i = value - 1;
            int j = Math.max(value, map.get(i));
            map.remove(i);
            map.put(i, j);
        } else if (map.containsValue(value - 1)) {
            int i = findKey(value - 1, map);
            map.remove(i);
            map.put(i, value);
        } else if (!isInsideInterval(value, map)) {
            map.put(value, value);
        }
    }

    public boolean isInsideInterval(int n, Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (n <= entry.getValue() && n >= entry.getKey()) {
                return true;
            }
        }
        return false;
    }

    public int findKey(int value, Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public int[][] getIntervals() {
        int[][] res = map.entrySet().stream().map(entry -> new int[]{entry.getKey(), entry.getValue()}).toArray(int[][]::new);
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return res;
    }
}
