package com.dsagame.leetcode.dailychallenge.feb;

public class Leetcode567 {
    public static void main(String[] args) {
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] frequency = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
            frequency[s2.charAt(i) - 'a']--;
        }
        if (isEqual(frequency)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            frequency[s2.charAt(i) - 'a']--;
            frequency[s2.charAt(i - s1.length()) - 'a']++;
            if (isEqual(frequency)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEqual(int[] arr) {
        for (int x : arr) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
