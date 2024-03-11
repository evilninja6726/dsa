package com.dsagame.leetcode.dailychallenge.feb;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int[] frequency = new int[26];
        for (int i = 0; i < p.length(); i++) {
            frequency[p.charAt(i) - 'a']++;
            frequency[s.charAt(i) - 'a']--;
        }
        if (isAnagram(frequency)) {
            res.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']--;
            frequency[s.charAt(i - p.length()) - 'a']++;
            if (isAnagram(frequency)) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }

    public static boolean isAnagram(int[] frequency) {
        for (int x : frequency) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
