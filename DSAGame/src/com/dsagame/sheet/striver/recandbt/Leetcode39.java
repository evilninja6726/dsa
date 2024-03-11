package com.dsagame.sheet.striver.recandbt;

import java.util.ArrayList;
import java.util.List;

public class Leetcode39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, 0, target, new ArrayList<>(), res);
        return res;
    }

    public static void helper(int[] arr, int idx, int sum, int target, List<Integer> localList, List<List<Integer>> res) {
        if (idx == arr.length) {
            if (sum == target) {
                res.add(new ArrayList<>(localList));
            }
            return;
        }
        if (sum < target) {
            localList.add(arr[idx]);
            helper(arr, idx, sum + arr[idx], target, localList, res);
            localList.remove(localList.size() - 1);
        }
        helper(arr, idx + 1, sum, target, localList, res);
    }
}
