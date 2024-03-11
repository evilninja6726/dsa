package com.dsagame.gfgextras.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(toh(3, 1, 2, 3));
    }

    //move disk 1 from rod 1 to rod 2
    public static long toh(int N, int from, int to, int aux) {
        // Your code here
        if (N == 0) {
            return 0;
        }
        long res = toh(N - 1, from, aux, to);
        res++;
        System.out.println("move disc " + N + " rod " + from + " to rod " + to);
        res += toh(N - 1, aux, to, from);
        return res;
    }
}
