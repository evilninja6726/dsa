package com.dsagame.leetcode.math.medium;

import java.util.Arrays;

public class Leetcode204 {
    public static void main(String[] args) {

    }

    public static boolean isPrime(int n) {
        if (n <= 0 || n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 4; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        int res = -2;
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= n; i++) {
            if (isPrime(i)) {
                for (int j = 2 * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (boolean b : primes) {
            if (b) {
                res++;
            }
        }
        if (isPrime(n)) {
            res--;
        }
        return res;
    }
}
