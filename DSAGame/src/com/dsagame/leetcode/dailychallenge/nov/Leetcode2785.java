package com.dsagame.leetcode.dailychallenge.nov;

public class Leetcode2785 {
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels("lYmpH"));
    }

    public static String sortVowels(String s) {
        int[] capital = new int[26];
        int[] small = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                if (Character.isUpperCase(s.charAt(i))) {
                    capital[s.charAt(i) - 'A']++;
                } else {
                    small[s.charAt(i) - 'a']++;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                putVowel(capital, small, res);
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    public static void putVowel(int[] capital, int[] small, StringBuilder res) {
        for (int j = 0; j < capital.length; j++) {
            if (capital[j]-- > 0) {
                res.append((char) (j + 'A'));
                return;
            }
        }
        for (int j = 0; j < small.length; j++) {
            if (small[j]-- > 0) {
                res.append((char) (j + 'a'));
                return;
            }
        }
    }
}
