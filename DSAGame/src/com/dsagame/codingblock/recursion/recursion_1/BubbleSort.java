package com.dsagame.codingblock.recursion.recursion_1;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1};
        bubbleSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, int i, int n) {
        if (n == 1) {
            return;
        }
        if (i != n - 1) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            bubbleSort(arr, i + 1, n);
        }
        bubbleSort(arr, 0, n - 1);
    }
}

class bubble_sort {

    static int n;

    static void buble(int i, int j, int[] a) {
        if (i < n) {
            if (j < n - 1) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
                buble(i, j + 1, a);
            }
            buble(i + 1, 0, a);
        }
    }
}