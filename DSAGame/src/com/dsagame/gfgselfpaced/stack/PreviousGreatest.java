package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PreviousGreatest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(previousGreatest(new int[]{15, 10, 18, 12, 4, 6, 2, 8})));
    }

    public static int[] previousGreatest(int[] arr) {
        int[] res = new int[arr.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        res[0] = -1;
        for (int i = 1; i < arr.length; i++) {
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
