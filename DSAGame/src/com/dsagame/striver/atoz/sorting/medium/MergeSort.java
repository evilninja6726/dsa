package com.dsagame.striver.atoz.sorting.medium;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        mergeSort(new int[]{4, 3, 2, 1, 4, 6, 6, 8, 9, 0});
    }

    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortHelper(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSortHelper(arr, low, mid);
        mergeSortHelper(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] mergedArr = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                mergedArr[k++] = arr[i++];
            } else {
                mergedArr[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            mergedArr[k++] = arr[i++];
        }
        while (j <= high) {
            mergedArr[k++] = arr[j++];
        }
        if (high + 1 - low >= 0) {
            System.arraycopy(mergedArr, 0, arr, low, high + 1 - low);
        }
    }
}
