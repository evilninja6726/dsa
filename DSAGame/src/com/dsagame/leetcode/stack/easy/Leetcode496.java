package com.dsagame.leetcode.stack.easy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class Leetcode496 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        map.put(nums2[nums2.length - 1], -1);
        stack.push(nums2.length - 1);
        for (int i = nums2.length - 2; i >= 0; i--) {
            if (!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
                while (!stack.isEmpty() && nums2[i] >= nums2[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    map.put(nums2[i], -1);
                } else {
                    map.put(nums2[i], nums2[stack.peek()]);
                }
            } else {
                map.put(nums2[i], nums2[stack.peek()]);
            }
            stack.push(i);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
