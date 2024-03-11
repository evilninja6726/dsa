package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestAreaOfHistogram {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(previousSmaller(new int[]{6, 2, 5, 4, 1, 5, 6})));
        System.out.println(Arrays.toString(nextSmaller(new int[]{6, 2, 5, 4, 1, 5, 6})));
        System.out.println(largestRectangleAreaEff(new int[]{3, 1, 3, 2, 2}));
    }

    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int[] previousSmaller = previousSmaller(heights);
        int[] nextSmaller = nextSmaller(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (nextSmaller[i] - previousSmaller[i] - 1) * heights[i]);
        }
        return res;
    }

    public static int largestRectangleAreaEff(int[] heights) {
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int minHeight = stack.pop();
                res = Math.max(res, heights[minHeight] * ((stack.isEmpty()) ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int minHeight = stack.pop();
            res = Math.max(res, heights[minHeight] * ((stack.isEmpty()) ? heights.length : heights.length - stack.peek() - 1));
        }
        return res;
    }

    public static int[] previousSmaller(int[] arr) {
        int[] res = new int[arr.length];
        res[0] = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        return res;
    }

    public static int[] nextSmaller(int[] arr) {
        int[] res = new int[arr.length];
        res[res.length - 1] = res.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(res.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? arr.length : stack.peek();
            stack.push(i);
        }
        return res;
    }
}
