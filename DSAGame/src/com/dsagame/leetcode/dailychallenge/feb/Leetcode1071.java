package com.dsagame.leetcode.dailychallenge.feb;

public class Leetcode1071 {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("ABCACB", "ABC"));
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        } else if (str1.length() == str2.length()) {
            return str1;
        }
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2.substring(str1.length()), str1);
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
