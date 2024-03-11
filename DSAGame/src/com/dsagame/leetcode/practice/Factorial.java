package com.dsagame.leetcode.practice;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(400));
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
