package com.dsagame.leetcode.dailychallenge.feb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode2306 {
    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }

    public static long distinctNames(String[] ideas) {
        Set<String> ideaSet = new HashSet<>(Arrays.asList(ideas));
        // return helper(ideas, 0, ideaSet);
        //return helperMem(ideas, 0, ideaSet, new long[50000]);
        long[][] dp = new long[26][26];
        for (String idea : ideas) {
            for (int j = 0; j < 26; j++) {
                StringBuilder convertedString = new StringBuilder(idea);
                convertedString.setCharAt(0, (char) (j + 'a'));
                if (!ideaSet.contains(convertedString.toString())) {
                    dp[idea.charAt(0) - 'a'][j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    res += (dp[i][j] * dp[j][i]);
                }
            }
        }
        return res;
    }

    //    Input: ideas = ["coffee","donuts","time","toffee"]
//    Output: 6
    public static long helper(String[] arr, int index, Set<String> set) {
        if (index == arr.length) {
            return 0;
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                StringBuilder s1 = new StringBuilder(arr[index]);
                StringBuilder s2 = new StringBuilder(arr[i]);
                char temp = s1.charAt(0);
                s1.setCharAt(0, s2.charAt(0));
                s2.setCharAt(0, temp);
                if (!set.contains(s1.toString()) && !set.contains(s2.toString())) {
                    res++;
                }
            }
        }
        res += helper(arr, index + 1, set);
        return res;
    }

    public static long helperMem(String[] arr, int index, Set<String> set, long[] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[index] != 0) {
            return dp[index];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                StringBuilder s1 = new StringBuilder(arr[index]);
                StringBuilder s2 = new StringBuilder(arr[i]);
                char temp = s1.charAt(0);
                s1.setCharAt(0, s2.charAt(0));
                s2.setCharAt(0, temp);
                if (!set.contains(s1.toString()) && !set.contains(s2.toString())) {
                    dp[index]++;
                }
            }
        }
        dp[index] += helper(arr, index + 1, set);
        return dp[index];
    }
}
