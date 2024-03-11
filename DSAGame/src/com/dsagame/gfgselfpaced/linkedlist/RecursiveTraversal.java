package com.dsagame.gfgselfpaced.linkedlist;

public class RecursiveTraversal {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        print(slNode);
    }

    public static void print(SLNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + " ");
        print(head.next);
    }
}
