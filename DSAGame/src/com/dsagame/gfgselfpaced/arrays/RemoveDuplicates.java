package com.dsagame.gfgselfpaced.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 3, 3, 4, 5, 6, 7, 7, 9}));
    }

    public static int removeDuplicates(int[] arr) {
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return res;
    }
}
