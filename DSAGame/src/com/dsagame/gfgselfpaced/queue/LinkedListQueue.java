package com.dsagame.gfgselfpaced.queue;

public class LinkedListQueue {
    Node front;
    int size;
    Node rear;

    public LinkedListQueue() {
    }

    public void enqueue(int x) {
        if (isEmpty()) {
            rear = new Node(x);
            front = rear;
            return;
        }
        rear.next = new Node(x);
        rear = rear.next;
    }

    public void dequeue() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return;
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public int getFront() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }

    public int getRear() {
        if (front == null) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return rear.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
