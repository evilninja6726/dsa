package com.dsagame.leetcode.stack.medium;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Leetcode503 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        int[] res = new int[nums.length];
        res[maxIndex] = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(maxIndex);
        int i = maxIndex - 1;
        while (i != maxIndex) {
            if (i == -1) {
                i = nums.length - 1;
                if (i == maxIndex) {
                    break;

                }
            }
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? -1 : nums[stack.peek()];
            stack.push(i--);
        }
        return res;
    }
}
