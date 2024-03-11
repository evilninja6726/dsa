package com.dsagame.gfgselfpaced.heap;

import java.util.Arrays;

public class MinHeapDemo {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(15);
//        minHeap.insert(10);
//        minHeap.insert(20);
//        minHeap.insert(30);
//        minHeap.insert(5);
//        minHeap.insert(2);
//        minHeap.insert(1);
//        minHeap.insert(3);
//        minHeap.insert(0);
//        System.out.println(Arrays.toString(minHeap.arr));
////        minHeap.decreaseKey(7, 4);
////        System.out.println(Arrays.toString(minHeap.arr));
//        minHeap.delete(0);
//        System.out.println(Arrays.toString(minHeap.arr));
        int[] arr = new int[]{7, 6, 3, 2, 4, 5, 6, 3, 1, 1, 0};
        minHeap.size = arr.length;
        minHeap.buildHeap(arr);
        System.out.println(Arrays.toString(arr));
        // minHeap.decreaseKey();

//        minHeap.arr = new int[]{40, 20, 30, 35, 25, 80, 32, 100, 70, 60};
//        minHeap.size = minHeap.arr.length;
//        minHeap.heapify(0);
//        System.out.println(Arrays.toString(minHeap.arr));
//        System.out.println(minHeap.extractMin());
//        System.out.println(Arrays.toString(minHeap.arr));
    }
}
