package com.dsagame.gfgselfpaced.heap;

public class MinHeap {
    int[] arr;
    int size;
    int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        size = 0;
        arr = new int[capacity];
    }

    public int left(int i) {
        return 2 * i + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void insert(int x) {
        if (size == capacity) {
            System.out.println("Heap is Full");
            return;
        }
        int i = size++;
        arr[i] = x;
        while (i != 0 && arr[i] < arr[parent(i)]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void heapify(int i, int[] arr) {
        int left = left(i);
        int right = right(i);
        int minIndex = i;
        if (left < size && arr[left] < arr[minIndex]) {
            minIndex = left;
        }
        if (right < size && arr[right] < arr[minIndex]) {
            minIndex = right;
        }
        if (minIndex != i) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            heapify(minIndex, arr);
        }
    }

    public int getMin() {
        if (size == 0) {
            System.out.println("Heap is Empty");
            return -1;
        }
        return arr[0];
    }

    public int extractMin() {
        if (size == 0) {
            System.out.println("Heap is Empty");
            return -1;
        } else if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[--size];
        arr[size] = temp;
        heapify(0, arr);
        return temp;
    }

    public void decreaseKey(int i, int key) {
        arr[i] = key;
        while (i != 0 && arr[i] < arr[parent(i)]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }

    public void delete(int i) {
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    public void buildHeap(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapify(i, arr);
        }
    }
}
