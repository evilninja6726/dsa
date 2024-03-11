package com.dsagame.leetcode.dailychallenge.jan;

public class Leetcode520 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("Rajat"));
        System.out.println(detectCapitalUse("rajat"));
        System.out.println(detectCapitalUse("RAJAT"));
        System.out.println(detectCapitalUse("rajaT"));
        System.out.println(detectCapitalUse("RajaT"));
        System.out.println(detectCapitalUse("RAJAt"));
        System.out.println(detectCapitalUse("Flag"));
    }

    public static boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        boolean isFirstCharCapital = word.charAt(0) >= 65 && word.charAt(0) <= 90;
        boolean isSecondCharCapital = word.charAt(1) >= 65 && word.charAt(1) <= 90;
        if (!isFirstCharCapital && isSecondCharCapital) {
            return false;
        } else if (word.length() == 2) {
            return true;
        }
        for (int i = 2; i < word.length(); i++) {
            if (isSecondCharCapital && word.charAt(i) >= 97 && word.charAt(i) <= 122) {
                return false;
            } else if (!isSecondCharCapital && word.charAt(i) >= 65 && word.charAt(i) <= 90) {
                return false;
            }
        }
        return true;
    }
}
