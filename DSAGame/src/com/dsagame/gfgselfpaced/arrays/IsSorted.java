package com.dsagame.gfgselfpaced.arrays;

public class IsSorted {
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 1, 2, 3, 3, 4, 5, 6, 7}));
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
