package com.dsagame.gfgselfpaced.stack;

import java.util.Arrays;

public class KStacks {
    int capacity;
    int k;
    int freeSpot;
    int[] arr;
    int[] top;
    int[] next;

    public KStacks(int k, int capacity) {
        this.k = k;
        this.capacity = capacity;
        freeSpot = 0;
        this.arr = new int[capacity];
        this.top = new int[k];
        this.next = new int[capacity];
        Arrays.fill(top, -1);
        for (int i = 0; i < capacity; i++) {
            next[i] = i + 1;
        }
        next[capacity - 1] = -1;
    }

    public void push(int k, int x) {
        if (freeSpot == -1) {
            System.out.println("Stack is Full, can't push");
            return;
        }
        int index = freeSpot;
        freeSpot = next[index];
        arr[index] = x;
        next[index] = top[k];
        top[k] = index;
    }

    public int pop(int k) {
        if (top[k] == -1) {
            System.out.println("Stack is Empty, can't pop");
            return -1;
        }
        int index = top[k];
        top[k] = next[index];
        int itemToBePopped = arr[index];
        next[index] = freeSpot;
        freeSpot = index;
        return itemToBePopped;
    }

    public int size(int k) {
        return top[k] + 1;
    }
}
