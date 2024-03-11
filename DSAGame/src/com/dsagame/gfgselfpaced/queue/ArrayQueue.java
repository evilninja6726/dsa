package com.dsagame.gfgselfpaced.queue;

public class ArrayQueue {
    int[] arr;
    int size;
    int capacity;
    int front;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.front = 0;
    }

    public void enqueue(int x) {
//        if (size == capacity) {
//            System.out.println("Queue is Full");
//            return;
//        }
//        arr[size++] = x;
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        int rear = (getRear() + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    public int dequeue() {
//        if (size == 0) {
//            System.out.println("Queue is Empty");
//            return -1;
//        }
//        int front = arr[0];
//        if ((size--) - 1 >= 0) {
//            System.arraycopy(arr, 1, arr, 0, size - 1);
//        }
//        return front;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int res = arr[front++];
        front %= capacity;
        size--;
        return res;
    }

    public int getFront() {
//        if (size == 0) {
//            System.out.println("Queue is Empty");
//            return -1;
//        }
//        return arr[0];
        if (isEmpty()) {
            return -1;
        }
        return front;
    }

    public int getRear() {
//        if (size == 0) {
//            System.out.println("Queue is Empty");
//            return -1;
//        }
//        return arr[size - 1];
        if (isEmpty()) {
            return -1;
        }
        return (front + size - 1) % capacity;
    }

    public boolean isEmpty() {
        // return size == 0;
        return size == 0;
    }

    public boolean isFull() {
        // return size == capacity;
        return size == capacity;
    }

    public int size() {
        //   return size;
        return size;
    }
}
