package com.dsagame.practice;

public class PQInverseModM {
    public static void main(String[] args) {
        System.out.println(calculate(56, 3));
    }

    static long calculate(long p, long q) {
        long mod = 998244353, expo;
        expo = mod - 2;
        while (expo != 0) {
            if ((expo & 1) == 1) {
                p = (p * q) % mod;
            }
            q = (q * q) % mod;
            expo >>= 1;
        }
        return p;
    }
}
