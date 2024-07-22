package com.dsagame.striver.atoz.basic.maths;

public class SumOfAllDivisors {
    public static void main(String[] args) {

    }

    //gfg
    static long sumOfDivisors(int N) {
        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += (long) (N / i) * i;
        }
        return res;
    }
}
