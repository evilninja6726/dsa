package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpanProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stockSpan(new int[]{60, 10, 10, 10, 20, 40, 35, 30, 50, 70, 65})));
    }

    public static int[] stockSpan(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            if (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    stack.pop();
                }
                res[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
            } else {
                res[i] = 1;
            }
            stack.push(i);
        }
        return res;
    }
}
