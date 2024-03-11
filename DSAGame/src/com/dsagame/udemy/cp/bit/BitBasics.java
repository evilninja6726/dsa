package com.dsagame.udemy.cp.bit;

public class BitBasics {
    public static void main(String[] args) {
        System.out.println(get(42, 3));
        System.out.println(get(42, 4));
        System.out.println(set(5, 1));
        System.out.println(set(5, 2));
        System.out.println(clear(21, 2));
        System.out.println(update(21, 3, 0));
        System.out.println(update(21, 3, 1));
        System.out.println(clearLastIBits(42, 3));
        System.out.println(clearLastIBits(15, 2));
        System.out.println(clearInRange(15, 3, 1));
        System.out.println(clearInRange(31, 3, 1));
        System.out.println(replace(256, 21, 6, 2));
        System.out.println(isPowerOfTwo(16));
        System.out.println(countSetBits(15));
        System.out.println(countSetBitsEff(15));
        System.out.println(countSetBitsEff(16));
        System.out.println(convertToBinary(15));
        System.out.println(convertToBinary(27));
        System.out.println(convertToBinary(390523));
        System.out.println(convertToBinary(42));
    }

    // get, set, clear, update ith bit
    public static int get(int n, int i) {
        return ((1 << i) & n) > 0 ? 1 : 0;
    }

    public static int set(int n, int i) {
        n |= (1 << i);
        return n;
    }

    public static int clear(int n, int i) {
        n &= ~(1 << i);
        return n;
    }

    public static int update(int n, int i, int b) {
        n = clear(n, i);
        int mask = (b << i);
        n |= mask;
        return n;
    }

    //clear last i bits
    public static int clearLastIBits(int n, int i) {
        n &= (-1 << i);
        return n;
    }

    //0-indexing    -1==~0
    public static int clearInRange(int n, int j, int i) {
        int rightMask = (1 << i) - 1;
        int leftMask = (-1 << (j + 1));
        int mask = rightMask | leftMask;
        n &= mask;
        return n;
    }

    //replace bits in range bits(m)==j-i+1
    public static int replace(int n, int m, int j, int i) {
        n = clearInRange(n, j, i);
        m <<= i;
        n |= m;
        return n;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }

    // log(n)
    public static int countSetBits(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    // O(setBits)
    public static int countSetBitsEff(int n) {
        int res = 0;
        while (n > 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    public static long convertToBinary(int n) {
        long power = 1;
        long res = 0;
        while (n > 0) {
            res += ((n & 1) * power);
            n >>= 1;
            power *= 10;
        }
        return res;
    }
}
