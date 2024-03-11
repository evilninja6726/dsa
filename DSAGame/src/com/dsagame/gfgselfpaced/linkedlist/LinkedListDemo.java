package com.dsagame.gfgselfpaced.linkedlist;

public class LinkedListDemo {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        while (slNode != null) {
            System.out.print(slNode.data + " ");
            slNode = slNode.next;
        }
    }
}
