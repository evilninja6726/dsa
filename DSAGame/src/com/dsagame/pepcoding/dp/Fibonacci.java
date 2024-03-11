package com.dsagame.pepcoding.dp;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(10, new int[11]));
    }

    public static int fib(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        } else if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }


}
