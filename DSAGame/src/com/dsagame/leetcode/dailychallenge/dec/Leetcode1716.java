package com.dsagame.leetcode.dailychallenge.dec;

public class Leetcode1716 {
    public static void main(String[] args) {
        System.out.println(totalMoney(20));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(4));
    }

    public static int totalMoney(int n) {
        int q = n / 7;
        int r = n % 7;
        int res = 0;
        for (int i = 1; i <= q; i++) {
            res += ((2 * i + 6) * 7) / 2;
        }
        res += ((2 * (q + 1) + (r - 1)) * r) / 2;
        return res;
    }
}
