package com.dsagame.pepcoding.dp;

public class CountEncodings {
    public static void main(String[] args) {
        System.out.println(countEncodings("123"));
    }

    public static int countEncodings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) == '0' && s.charAt(i) == '0') {
                dp[i] = 0;
            } else if (s.charAt(i - 1) == '0' && s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            } else {
                int iMinus2 = (i - 2 >= 0) ? dp[i - 2] : 1;
                if (s.charAt(i - 1) != '0' && s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == 2) {
                        dp[i] = iMinus2;
                    } else {
                        dp[i] = 0;
                    }
                } else {
                    if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
                        dp[i] = dp[i - 1] + iMinus2;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                }
            }
        }

        return dp[dp.length - 1];
    }
}
