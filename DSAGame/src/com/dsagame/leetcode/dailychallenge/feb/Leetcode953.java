package com.dsagame.leetcode.dailychallenge.feb;

import java.util.HashMap;
import java.util.Map;

public class Leetcode953 {
    public static void main(String[] args) {
        /*
         * words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
         * words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
         * words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"*/
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode", "lza", "lza"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            int smallLength = Math.min(words[i].length(), words[i + 1].length());
            boolean equalTillSmallLength = false;
            for (int j = 0; j < smallLength; j++) {
                if (map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j))) {
                    return false;
                } else if (map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j))) {
                    break;
                }
                if (j == smallLength - 1) {
                    equalTillSmallLength = true;
                }
            }
            if (equalTillSmallLength && words[i].length() > words[i + 1].length()) {
                return false;
            }
        }
        return true;
    }
}
