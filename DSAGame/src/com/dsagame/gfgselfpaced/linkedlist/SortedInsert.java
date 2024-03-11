package com.dsagame.gfgselfpaced.linkedlist;

public class SortedInsert {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode = insert(slNode, 35);
        slNode = insert(slNode, 50);
        slNode = insert(slNode, 5);
        slNode = insert(slNode, 5);
        slNode = insert(slNode, 35);
        while (slNode != null) {
            System.out.print(slNode.data + "->");
            slNode = slNode.next;
        }
    }

    public static SLNode insert(SLNode head, int x) {
        if (head == null) {
            return new SLNode(x);
        }
        SLNode curr = head;
        SLNode prev = null;
        while (curr != null && curr.data < x) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            prev = new SLNode(x);
            prev.next = head;
            return prev;
        }
        SLNode newNode = new SLNode(x);
        newNode.next = curr;
        prev.next = newNode;
        return head;
    }
}
