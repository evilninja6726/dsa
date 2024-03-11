package com.dsagame.gfgselfpaced.linkedlist;

public class InsertAtSpecificPosition {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode = insert(slNode, 0, 25);
        while (slNode != null) {
            System.out.print(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static SLNode insert(SLNode head, int position, int newNodeData) {
        if (position < 1) {
            return head;
        }
        SLNode newNode = new SLNode(newNodeData);
        if (position == 1) {
            newNode.next = head;
            return newNode;
        }
        SLNode curr = head;
        for (int i = 0; i < position - 2 && curr != null; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            return head;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}
