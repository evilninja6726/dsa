package com.dsagame.practice;

public class LongestPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(longestPalin("aaaabbaa"));
    }

    static String longestPalin(String S) {
        String x = "";
        x += S.charAt(0);
        int l = 0;
        int n = S.length();

        for (int i = 0; i < n; i++) {
            int i1 = i;
            int i2 = i + 1;
            while (i1 >= 0 && i2 < n) {
                if (S.charAt(i1) == S.charAt(i2)) {
                    int len = i2 - i1 + 1;
                    if (len > l) {
                        l = len;
                        x = S.substring(i1, len);
                    }
                } else {
                    break;
                }
                i1--;
                i2++;
            }
        }
        for (int i = 0; i < n; i++) {
            int i1 = i - 1;
            int i2 = i + 1;
            while (i1 >= 0 && i2 < n) {
                if (S.charAt(i1) == S.charAt(i2)) {
                    int len = i2 - i1 + 1;
                    if (len > l) {
                        l = len;
                        x = S.substring(i1, len);
                    }
                } else {
                    break;
                }
                i1--;
                i2++;
            }

        }
        return x;
    }
}
