package com.dsagame.striver.atoz.basic.maths;

import java.util.ArrayList;
import java.util.List;

public class Armstrong {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153) + " " + isArmstrong(0) + " " + isArmstrong(1) + " " + isArmstrong(25) + " " + isArmstrong(370));
    }

    public static boolean isArmstrong(int n) {
        List<Integer> digits = createDigitsList(n);
        long res = digits.stream().mapToLong(digit -> power(digit, digits.size())).sum();
        return res == n;
    }

    public static List<Integer> createDigitsList(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    public static long power(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        long half = power(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return a * half * half;
        }
    }
}
