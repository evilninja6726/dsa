package com.dsagame.striver.atoz.basic.maths;

public class GCD {
    public static void main(String[] args) {

    }

    // gfg
    static Long[] lcmAndGcd(Long A, Long B) {
        Long[] res = new Long[2];
        Long gcd = gcd(A, B);
        res[0] = A * B / gcd;
        res[1] = gcd;
        return res;
    }

    static Long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
