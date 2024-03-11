package com.dsagame.gfgselfpaced.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(kClosestElements(new int[]{10, 15, 7, 3, 4}, 2, 8)));
    }

    public static int[] kClosestElements(int[] arr, int k, int x) {
        int[] res = new int[k];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.diff - o1.diff;
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
        }
        for (int i = k; i < arr.length; i++) {
            if (!maxHeap.isEmpty() && Math.abs(arr[i] - x) < maxHeap.peek().diff) {
                maxHeap.poll();
                maxHeap.add(new Pair(arr[i], Math.abs(arr[i] - x)));
            }
        }
        int index = 0;
        while (!maxHeap.isEmpty()) {
            res[index++] = maxHeap.poll().value;
        }
        return res;
    }
}

class Pair {
    int value;
    int diff;

    public Pair(int value, int diff) {
        this.value = value;
        this.diff = diff;
    }
}