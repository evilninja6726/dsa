package com.dsagame.leetcode.dp.medium;

public class Leetcode650 {
    public static void main(String[] args) {
        System.out.println(minSteps(1));
    }

    public static int minSteps(int n) {
        if (n == 2 || n == 3) {
            return n;
        }
        int res = 0;
        for (int i = 2; i * i <= n; ) {
            if (n % i == 0) {
                res += i;
                n /= i;
            } else {
                i++;
            }
        }
        return (n == 1) ? res : res + n;
    }
}
