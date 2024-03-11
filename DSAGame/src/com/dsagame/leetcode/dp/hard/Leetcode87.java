package com.dsagame.leetcode.dp.hard;

public class Leetcode87 {
    public static void main(String[] args) {
        System.out.println(isScrambleRec("great", "rgeat"));
        System.out.println(isScrambleRec("abcde", "caebd"));
    }

    public static boolean isScrambleRec(String s1, String s2) {
        //return helper(s1, s2);
        //return helper(s1, s2, 0, 0, s1.length());
        Boolean[][][] dp = new Boolean[s1.length()][s2.length()][s1.length() + 1];
        return helper(s1, s2, 0, 0, s1.length(), dp);
    }

    public static boolean helper(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        for (int i = 1; i < s1.length(); i++) {
            if ((helper(s1.substring(0, i), s2.substring(0, i)) && helper(s1.substring(i), s2.substring(i))) || (helper(s1.substring(0, i), s2.substring(s2.length() - i)) && helper(s1.substring(i), s2.substring(0, s2.length() - i)))) {
                return true;
            }
        }
        return false;
    }

    public static boolean helper(String s1, String s2, int i, int j, int length) {
        if (s1.substring(i, i + length).equals(s2.substring(j, j + length))) {
            return true;
        }
        for (int c = 1; c < length; c++) {
            if ((helper(s1, s2, i, j, c) && helper(s1, s2, i + c, j + c, length - c))
                    || (helper(s1, s2, i, j + length - c, c) && helper(s1, s2, i + c, j, length - c))) {
                return true;
            }
        }
        return false;
    }

    public static boolean helper(String s1, String s2, int i, int j, int length, Boolean[][][] dp) {
        if (s1.substring(i, i + length).equals(s2.substring(j, j + length))) {
            return true;
        }
        if (dp[i][j][length] != null) {
            return dp[i][j][length];
        }
        for (int c = 1; c < length; c++) {
            if ((helper(s1, s2, i, j, c, dp) && helper(s1, s2, i + c, j + c, length - c, dp))
                    || (helper(s1, s2, i, j + length - c, c, dp) && helper(s1, s2, i + c, j, length - c, dp))) {
                dp[i][j][length] = true;
                return true;
            }
        }
        dp[i][j][length] = false;
        return false;
    }

    public boolean isScramble(String s1, String s2) {
        return true;
    }
}
