package com.dsagame.leetcode.dailychallenge.jan;

import java.util.Arrays;

public class Leetcode1833 {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{4, 7, 6, 4, 4, 2, 2, 4, 8, 8}, 41));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int res = 0;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (coins - cost < 0) {
                break;
            }
            res++;
            coins -= cost;
        }
        return res;
    }
}
