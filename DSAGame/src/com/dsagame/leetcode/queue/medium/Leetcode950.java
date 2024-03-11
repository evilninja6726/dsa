package com.dsagame.leetcode.queue.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode950 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }

    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] res = new int[deck.length];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }
        Arrays.sort(deck);
        for (int i = 0; queue.size() > 1 && i < deck.length; i++) {
            res[queue.poll()] = deck[i];
            queue.offer(queue.poll());
        }
        res[queue.poll()] = deck[deck.length - 1];
        return res;
    }
}
