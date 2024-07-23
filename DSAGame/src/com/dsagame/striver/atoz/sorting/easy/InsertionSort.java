package com.dsagame.striver.atoz.sorting.easy;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{4, 3, 2, 1, 3, 4, 6, 8, 0});
    }

    //make current at correct position
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                arr[j - 1] ^= arr[j];
                arr[j] ^= arr[j - 1];
                arr[j - 1] ^= arr[j--];
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
