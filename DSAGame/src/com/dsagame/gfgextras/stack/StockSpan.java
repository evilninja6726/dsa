package com.dsagame.gfgextras.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class StockSpan {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(calculateSpan(new int[]{100, 80, 60, 70, 60, 75, 85, 200}, 8)));
    }

    public static int[] calculateSpan(int[] price, int n) {
        int[] res = new int[n];
        res[0] = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            res[i] = (stack.isEmpty()) ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return res;
    }
}
