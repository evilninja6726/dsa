package com.dsagame.striver.recandbt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 2, 2, 4, 6, 7, 2, 1, 4, 0};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
        mergeSortSimple(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortSimple(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int mid = (i + j) / 2;
        mergeSortSimple(arr, i, mid);
        mergeSortSimple(arr, mid + 1, j);
        merge(arr, i, mid, j);
    }

    public static void merge(int[] arr, int i, int m, int j) {
        List<Integer> res = new ArrayList<>();
        int x = i, y = m + 1;
        while (x <= m || y <= j) {
            if (x > m) {
                res.add(arr[y++]);
            } else if (y > j) {
                res.add(arr[x++]);
            } else {
                if (arr[x] <= arr[y]) {
                    res.add(arr[x++]);
                } else {
                    res.add(arr[y++]);
                }
            }
        }
        for (int k = i; k <= j; k++) {
            arr[k] = res.get(k - i);
        }
    }

    public static int[] mergeSort(int[] arr, int i, int j) {
        if (i == j) {
            return new int[]{arr[i]};
        }
        int mid = (i + j) / 2;
        int[] arr1 = mergeSort(arr, i, mid);
        int[] arr2 = mergeSort(arr, mid + 1, j);
        return merge(arr1, arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (i >= arr1.length) {
                res[k++] = arr2[j++];
            } else if (j >= arr2.length) {
                res[k++] = arr1[i++];
            } else {
                if (arr1[i] <= arr2[j]) {
                    res[k++] = arr1[i++];
                } else {
                    res[k++] = arr2[j++];
                }
            }
        }
        return res;
    }
}
