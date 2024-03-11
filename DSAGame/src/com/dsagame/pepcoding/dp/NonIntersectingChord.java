package com.dsagame.pepcoding.dp;

public class NonIntersectingChord {
    public static void main(String[] args) {
        System.out.println(numberOfNonIntersectingChords(4));
    }

    public static int numberOfNonIntersectingChords(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (double) ((4 * i) + 2) / (i + 2);
        }
        return res;
    }
}
