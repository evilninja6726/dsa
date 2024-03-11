package com.dsagame.leetcode.practice;

public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("rajat"));
    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char c = sb.charAt(i);
            sb.setCharAt(i++, sb.charAt(j));
            sb.setCharAt(j--, c);
        }
        return sb.toString();
    }
}
