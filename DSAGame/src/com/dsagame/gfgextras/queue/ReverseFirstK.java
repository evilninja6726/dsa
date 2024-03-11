package com.dsagame.gfgextras.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseFirstK {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= 5; i++) {
            queue.offer(i);
        }
        queue = modifyQueue(queue, 3);
        System.out.println(queue);
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        if (k == 0 || q.isEmpty()) {
            return q;
        }
        int front = q.poll();
        q = modifyQueue(q, k - 1);
        q.offer(front);
        return q;
    }
}
