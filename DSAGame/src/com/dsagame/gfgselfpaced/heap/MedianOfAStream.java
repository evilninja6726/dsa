package com.dsagame.gfgselfpaced.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfAStream {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianOfStream(new int[]{25, 7, 10, 15, 20})));
        double x = (4 + 7) / 2;
        System.out.println(x);
    }

    public static double[] medianOfStream(int[] arr) {
        if (arr.length == 1) {
            return new double[]{arr[0]};
        }
        PriorityQueue<Integer> firstContainer = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> secondContainer = new PriorityQueue<>();
        firstContainer.add(arr[0]);
        if (!firstContainer.isEmpty() && arr[1] < firstContainer.peek()) {
            secondContainer.add(firstContainer.poll());
            firstContainer.add(arr[1]);
        }
        double[] res = new double[arr.length];
        res[0] = arr[0];
        res[1] = (arr[0] + arr[1]) / 2.0;
        for (int i = 2; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] > secondContainer.peek()) {
                    firstContainer.add(secondContainer.poll());
                    secondContainer.add(arr[i]);
                } else {
                    firstContainer.add(arr[i]);
                }
                res[i] = firstContainer.peek();
            } else {
                if (arr[i] < firstContainer.peek()) {
                    secondContainer.add(firstContainer.poll());
                    firstContainer.add(arr[i]);
                } else {
                    secondContainer.add(arr[i]);
                }
                res[i] = (firstContainer.peek() + secondContainer.peek()) / 2.0;
            }
        }
        return res;
    }
}
