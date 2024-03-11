package com.dsagame.leetcode.heap.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode218 {
    public static void main(String[] args) {

    }

    /*
     Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
     Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]*/

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings.length == 1) {
            return Arrays.asList(Arrays.asList(buildings[0][0], buildings[0][2]), Arrays.asList(buildings[0][1], 0));
        }
        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(buildings[0][0], buildings[0][2]));
        for (int j = 1; j < buildings.length; j++) {
            if (buildings[j][0] <= buildings[i][1]) {
                if (buildings[j][2] != buildings[i][2]) {

                } else {

                }
            }
        }
        return res;
    }
}
