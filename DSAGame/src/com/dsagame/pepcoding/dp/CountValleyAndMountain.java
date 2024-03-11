package com.dsagame.pepcoding.dp;

public class CountValleyAndMountain {
    public static void main(String[] args) {
        System.out.println(count(4));
    }

    public static int count(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= (double) ((4 * i) + 2) / (i + 2);
        }
        return res;
    }
}
