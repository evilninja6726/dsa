package com.dsagame.gfgselfpaced.stack;

import java.util.Arrays;

public class TwoStacks {
    int capacity;
    int[] arr;
    int top1;
    int top2;

    public TwoStacks(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.top1 = -1;
        this.top2 = capacity;
    }

    public void push1(int x) {
        if (top1 + 1 == top2) {
            System.out.println("Stack 1 is Full, can't push");
            return;
        }
        arr[++top1] = x;
    }

    public void push2(int x) {
        if (top1 == top2 - 1) {
            System.out.println("Stack 2 is Full, can't push");
            return;
        }
        arr[--top2] = x;
    }

    public int pop1() {
        if (top1 == -1) {
            System.out.println("Stack 1 is Full, can't pop");
            return -1;
        }
        return arr[top1--];
    }

    public int pop2() {
        if (top2 == capacity) {
            System.out.println("Stack 2 is Full, can't pop");
            return -1;
        }
        return arr[top2++];
    }

    public int size1() {
        return top1 + 1;
    }

    public int size2() {
        return capacity - top2;
    }

    @Override
    public String toString() {
        return "TwoStacks{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
