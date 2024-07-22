package com.dsagame.striver.atoz.basic.maths;

public class CheckForPrime {
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
}
