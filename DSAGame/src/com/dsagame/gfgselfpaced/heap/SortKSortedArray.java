package com.dsagame.gfgselfpaced.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortKSortedArray(new int[]{9, 8, 7, 18, 19, 17}, 2)));
        System.out.println(Arrays.toString(sortKSortedArray(new int[]{24, 25, 35, 13, 37, 42, 4, 27, 16, 7, 10, 32, 41, 6}, 7)));
    }

    public static int[] sortKSortedArray(int[] arr, int k) {
        int[] res = new int[arr.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            minHeap.add(arr[i]);
        }
        int index = 0;
        for (int i = k + 1; !minHeap.isEmpty() && i < arr.length; i++) {
            res[index++] = minHeap.poll();
            minHeap.add(arr[i]);
        }
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        return res;
    }
}
