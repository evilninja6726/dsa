package com.dsagame.leetcode.dailychallenge.jan;

public class Leetcode926 {
    public static void main(String[] args) {

    }

    public static int minFlipsMonoIncr(String s) {
        int noOfOnes = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                noOfOnes++;
            } else if (noOfOnes > 0) {
                noOfOnes--;
                res++;
            }
        }
        return res;
    }
}
