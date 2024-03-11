package com.dsagame.gfgextras.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(generate(10));
    }

    public static ArrayList<String> generate(int N) {
        ArrayList<String> res = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("1");
        while (N-- > 0 && !queue.isEmpty()) {
            String front = queue.poll();
            res.add(front);
            queue.offer(front + "0");
            queue.offer(front + "1");
        }
        return res;
    }
}
