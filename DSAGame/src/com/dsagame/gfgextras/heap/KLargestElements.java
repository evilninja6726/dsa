package com.dsagame.gfgextras.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> kLargest(int[] arr, int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= arr[i]) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
