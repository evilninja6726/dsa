package com.dsagame.striver.atoz.arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {
    public static void main(String[] args) {
        System.out.println(leaders(5, new int[]{10, 4, 2, 4, 1}));
    }

    //actually gfg easy
    static ArrayList<Integer> leaders(int n, int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = arr[n - 1];
        res.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (max <= arr[i]) {
                max = arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
