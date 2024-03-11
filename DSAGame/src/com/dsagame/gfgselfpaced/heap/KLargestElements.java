package com.dsagame.gfgselfpaced.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kLargestElements(new int[]{12, 5, 787, 1, 23}, 2)));
    }

    public static int[] kLargestElements(int[] arr, int k) {
        int[] res = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; !minHeap.isEmpty() && i < arr.length; i++) {
            if (minHeap.peek() <= arr[i]) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll();
        }
        return res;
    }
}
