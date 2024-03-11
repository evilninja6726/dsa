package com.dsagame.leetcode.dp.hard;

import java.util.Arrays;

public class Leetcode132 {

    public static void main(String[] args) {
        // System.out.println(minCut("abccbc"));
        System.out.println(minCutEff("abccbc"));
        System.out.println(minCutEff("a"));
        System.out.println(minCutEff("aa"));
        System.out.println(minCutEff("aab"));
        System.out.println(minCutEff("ab"));
        System.out.println(minCutEff("efe"));
    }

    public static int minCut(String s) {
        Pair[][] dp = new Pair[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = new Pair();
            }
        }
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; i < dp.length && j < dp[0].length; i++, j++) {
                boolean isSameChar = s.charAt(i) == s.charAt(j);
                if (gap == 0 || (gap == 1 && isSameChar) || (isSameChar && dp[i + 1][j - 1].isPalindrome)) {
                    dp[i][j].isPalindrome = true;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(min, 1 + dp[i][k].minCuts + dp[k + 1][j].minCuts);
                    }
                    dp[i][j].minCuts = min;
                }
            }
        }
        for (Pair[] pairs : dp) {
            System.out.println(Arrays.toString(pairs));
        }
        return dp[0][dp.length - 1].minCuts;
    }

    public static int minCutEff(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int gap = 0; gap < isPalindrome.length; gap++) {
            for (int i = 0, j = gap; i < isPalindrome.length && j < isPalindrome[0].length; i++, j++) {
                boolean isSameChar = s.charAt(i) == s.charAt(j);
                if (gap == 0 || (gap == 1 && isSameChar) || (isSameChar && isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        int[] dp = new int[s.length()];
        for (int j = 1; j < dp.length; j++) {
            if (isPalindrome[0][j]) {
                dp[j] = 0;
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = j; i > 0; i--) {
                    if (isPalindrome[i][j]) {
                        min = Math.min(min, dp[i - 1]);
                    }
                }
                dp[j] = 1 + min;
            }
        }
        return dp[dp.length - 1];
    }

    static class Pair {
        boolean isPalindrome;
        int minCuts;

        public Pair(boolean isPalindrome, int minCuts) {
            this.isPalindrome = isPalindrome;
            this.minCuts = minCuts;
        }

        public Pair() {

        }

        @Override
        public String toString() {
            return isPalindrome +
                    " " + minCuts
                    ;
        }
    }
}
