package com.dsagame.leetcode.dailychallenge.jan;

import java.util.HashMap;

public class Leetcode290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat do"));
    }

    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");
        if (strings.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character key = pattern.charAt(i);
            String value = strings[i];
            if (!map.containsKey(key)) {
                if (map.containsValue(value)) {
                    return false;
                } else {
                    map.put(key, value);
                }
            } else {
                if (!map.get(key).equals(value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
