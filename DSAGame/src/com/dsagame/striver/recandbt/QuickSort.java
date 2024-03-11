package com.dsagame.striver.recandbt;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 1, 3, 6, 8, 5, 3, 1, 4, 6, 0, 7, 4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        while (i < j) {
            while (arr[i] <= arr[low] && i <= high) {
                i++;
            }
            while (arr[j] > arr[low] && j >= low) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }
}
