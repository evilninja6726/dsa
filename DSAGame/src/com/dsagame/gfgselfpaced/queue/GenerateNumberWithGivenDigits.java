package com.dsagame.gfgselfpaced.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateNumberWithGivenDigits {
    public static void main(String[] args) {
        generate(99);
    }

    public static void generate(int n) {
        if (n == 1) {
            System.out.print("5");
            return;
        } else if (n == 2) {
            System.out.print("5 6");
            return;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("5");
        queue.offer("6");
        while (n-- > 0 && !queue.isEmpty()) {
            String front = queue.poll();
            System.out.print(front + " ");
            queue.offer(front + "5");
            queue.offer(front + "6");
        }
    }
}
