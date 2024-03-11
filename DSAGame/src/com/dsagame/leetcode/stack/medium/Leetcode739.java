package com.dsagame.leetcode.stack.medium;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Leetcode739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{10, 20, 30, 40})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        res[res.length - 1] = 0;
        stack.push(res.length - 1);
        for (int i = res.length - 2; i >= 0; i--) {
            if (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                res[i] = (stack.isEmpty()) ? 0 : stack.peek() - i;
            } else {
                res[i] = 1;
            }
            stack.push(i);
        }
        return res;
    }
}
