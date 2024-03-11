package com.dsagame.gfgselfpaced.stack;

public class LinkedListStack {
    int top;
    Node head;

    public LinkedListStack() {
        this.top = -1;
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        top++;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is Empty, can't pop");
            return -1;
        }
        int topOfStack = head.data;
        head = head.next;
        top--;
        return topOfStack;
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return head.data;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
