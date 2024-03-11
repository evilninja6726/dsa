package com.dsagame.gfgselfpaced.stack;

public class ArrayStack {
    int top;
    int capacity;
    int[] arr;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.arr = new int[capacity];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Empty, can't pop");
            return -1;
        }
        return arr[top--];
    }

    public void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack is Full, can't push");
            return;
        }
        arr[(top++) + 1] = x;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
