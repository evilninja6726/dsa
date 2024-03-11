package com.dsagame.gfgselfpaced.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinMaxQueue {
    Deque<Integer> deque;

    public MinMaxQueue() {
        deque = new ArrayDeque<>();
    }

    public void insertMin(int x) {
        if (deque.isEmpty() || x < deque.peekFirst()) {
            deque.offerFirst(x);
        }
    }

    public void insertMax(int x) {
        if (deque.isEmpty() || x > deque.peekLast()) {
            deque.offerLast(x);
        }
    }

    public int getMin() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public int getMax() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekLast();
    }

    public int extractMin() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollFirst();
    }

    public int extractMax() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.pollLast();
    }
}
