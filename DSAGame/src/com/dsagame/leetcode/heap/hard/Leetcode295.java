package com.dsagame.leetcode.heap.hard;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian());// return 1.5 (i.e., (1 + 2) / 2));
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0);
    }
}

class MedianFinder {
    PriorityQueue<Integer> firstContainer;
    PriorityQueue<Integer> secondContainer;

    public MedianFinder() {
        firstContainer = new PriorityQueue<>(Collections.reverseOrder());
        secondContainer = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (firstContainer.isEmpty()) {
            firstContainer.add(num);
        } else if (secondContainer.isEmpty()) {
            if (num < firstContainer.peek()) {
                secondContainer.add(firstContainer.poll());
                firstContainer.add(num);
            } else {
                secondContainer.add(num);
            }
        } else if (firstContainer.size() == secondContainer.size()) {
            if (num > secondContainer.peek()) {
                firstContainer.add(secondContainer.poll());
                secondContainer.add(num);
            } else {
                firstContainer.add(num);
            }
        } else {
            if (num < firstContainer.peek()) {
                secondContainer.add(firstContainer.poll());
                firstContainer.add(num);
            } else {
                secondContainer.add(num);
            }
        }
    }

    public double findMedian() {
        if (!firstContainer.isEmpty()) {
            if (firstContainer.size() == secondContainer.size()) {
                return (firstContainer.peek() + secondContainer.peek()) / 2.0;
            } else {
                return firstContainer.peek();
            }
        }
        return -1;
    }
}

