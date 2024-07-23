package com.dsagame.striver.atoz.sorting.easy;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        selectionSort(new int[]{4, 5, 3, 2, 1, 3, 5, 7, 9, 0});
    }

    //make min at correct position
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
