package com.dsagame.leetcode.dailychallenge.dec;

public class Leetcode1903 {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("35427"));
        System.out.println(largestOddNumber("506"));
        System.out.println(largestOddNumber("5"));
        System.out.println(largestOddNumber("468882"));
    }

    public static String largestOddNumber(String num) {
        int lastIndex = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                lastIndex = i;
                break;
            }
        }
        return num.substring(0, lastIndex + 1);
    }

}