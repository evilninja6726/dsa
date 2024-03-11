package com.dsagame.gfgselfpaced.stack;

import java.util.ArrayDeque;

public class StackWithGetMin {
    ArrayDeque<Integer> stack;
    int min;

    public StackWithGetMin() {
        this.stack = new ArrayDeque<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int x) {
//        if (stack.isEmpty()) {
//            min = x;
//        }
//        stack.push((x < min) ? x - min : x);
        if (stack.isEmpty()) {
            min = x;
            stack.push(x);
            return;
        }
        if (x <= min) {
            stack.push(2 * x - min);
            min = x;
        } else {
            stack.push(x);
        }
    }

    public int pop() {
//        if (stack.isEmpty()) {
//            System.out.println("Stack is Empty, can't pop");
//            return -1;
//        }
//        int top = stack.pop();
//        if (top < 0) {
//            min -= top;
//            return min + top;
//        }
//        return top;
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty, can't pop");
            return -1;
        }
        int top = stack.pop();
        if (top <= min) {
            int res = min;
            min = 2 * min - top;
            return res;
        }
        return top;
    }

    public int getMin() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty");
        }
        return min;
    }

    public int peek() {
        if (stack.isEmpty()) {
            System.out.println("Stack is Empty, no peek");
            return -1;
        }
        return (stack.peek() <= min) ? min : stack.peek();
    }
}
