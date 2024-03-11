package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestRectangleWithAllOnes {
    public static void main(String[] args) {
        char[][] c = new char[2][2];
        for (char[] chars : c) {
            Arrays.fill(chars, '1');
        }
        System.out.println(maximalRectangle(new char[][]{{'0', '1'}, {'1', '0'}}));
    }

    public static int maximalRectangle(char[][] matrix) {
        int[][] arr = charToInt(matrix);
        int res = largestAreaOfHistogram(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (arr[i][j] == 0) ? 0 : arr[i][j] + arr[i - 1][j];
            }
            res = Math.max(res, largestAreaOfHistogram(arr[i]));
        }
        return res;
    }

    public static int[][] charToInt(char[][] chars) {
        int[][] res = new int[chars.length][chars[0].length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                res[i][j] = Character.getNumericValue(chars[i][j]);
            }
        }
        return res;
    }

    public static int largestAreaOfHistogram(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int minHeight = stack.pop();
                res = Math.max(res, arr[minHeight] * ((stack.isEmpty() ? i : i - stack.peek() - 1)));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int minHeight = stack.pop();
            res = Math.max(res, arr[minHeight] * ((stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1)));
        }
        return res;
    }
}
