package com.dsagame.pepcoding.dp;

import java.util.Arrays;

public class CountAPlusBPlusCPlusSubs {
    public static void main(String[] args) {
        System.out.println(count("abbc"));
        System.out.println(count("abcabc"));
        System.out.println(countEff("abbc"));
        System.out.println(countEff("abcabc"));
    }

    public static int count(String s) {
        int[][] dp = new int[3][s.length() + 1];
        for (int j = 1; j < dp[0].length; j++) {
            for (int i = 0; i < 3; i++) {
                if ((i == 0 && s.charAt(j - 1) == 'a') || (i == 1 && s.charAt(j - 1) == 'b') || (i == 2 && s.charAt(j - 1) == 'c')) {
                    dp[i][j] = 2 * dp[i][j - 1] + ((i == 0) ? 1 : dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[2][s.length()];
    }

    public static int countEff(String s) {
        int[] dp = new int[s.length() + 1];
        int aPlus = 0;
        int aPlusBPlus = 0;
        int aPlusBPlusCPlus = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aPlus = 2 * aPlus + 1;
                dp[i + 1] = aPlus;
            } else if (s.charAt(i) == 'b') {
                aPlusBPlus = 2 * aPlusBPlus + aPlus;
                dp[i + 1] = aPlusBPlus;
            } else {
                aPlusBPlusCPlus = 2 * aPlusBPlusCPlus + aPlusBPlus;
                dp[i + 1] = aPlusBPlusCPlus;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
