package com.dsagame.gfgselfpaced.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        reverse(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public static void reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int front = queue.poll();
        reverse(queue);
        queue.offer(front);
    }
}
