package com.dsagame.gfgselfpaced.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxItemWithGivenSum {
    public static void main(String[] args) {
        System.out.println(maxItems(new int[]{1, 9, 8, 12, 5, 111, 232, 1, 2, 4, 3}, 11));
    }

    public static int maxItems(int[] arr, int sum) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int maxSum = 0;
        for (int price : arr) {
            maxSum += price;
            maxHeap.add(price);
            if (maxSum > sum) {
                maxSum -= maxHeap.poll();
            }
        }
        return maxHeap.size();
    }
}
