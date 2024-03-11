package com.dsagame.gfgselfpaced.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 2, 7, 3, 0, 9, 8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, i, 0);
        }
    }

    public static int[] sortArray(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            maxHeapify(nums, i, 0);
        }
        return nums;
    }

    public static void maxHeapify(int[] arr, int n, int i) {
        int left = left(i);
        int right = right(i);
        int maxIndex = i;
        if (left < n && arr[maxIndex] < arr[left]) {
            maxIndex = left;
        }
        if (right < n && arr[maxIndex] < arr[right]) {
            maxIndex = right;
        }
        if (maxIndex != i) {
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
            maxHeapify(arr, n, maxIndex);
        }
    }

    public static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            maxHeapify(arr, arr.length, i);
        }
    }

    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }
}
