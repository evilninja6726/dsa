package com.dsagame.udemy.cp.bit;

public class FindTwoUniques {
    public static void main(String[] args) {

    }

    public static int[] find(int[] nums) {
        int xor = 0;
        for (int x : nums) {
            xor ^= x;
        }
        int i = 0;
        int temp = xor;
        while ((temp & 1) == 0) {
            i++;
            temp >>= 1;
        }
        int first = 0;
        for (int x : nums) {
            if ((x & (1 << i)) > 0) {
                first ^= x;
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = first ^ xor;
        return res;
    }
}
