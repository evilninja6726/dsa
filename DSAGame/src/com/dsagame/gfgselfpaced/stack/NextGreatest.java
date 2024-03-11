package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreatest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{5, 15, 10, 8, 6, 12, 9, 18})));
    }

    public static int[] nextGreaterElement(int[] arr) {
        int[] res = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(res.length - 1);
        res[res.length - 1] = -1;
        for (int i = res.length - 2; i >= 0; i--) {
            if (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    stack.pop();
                }
                res[i] = (stack.isEmpty()) ? -1 : arr[stack.peek()];
            } else {
                res[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }
}
