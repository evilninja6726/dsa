package com.dsagame.gfgselfpaced.linkedlist;

public class ReverseDLL {
    public static void main(String[] args) {
        DLNode head = new DLNode(10);
        DLNode node2 = new DLNode(20);
        DLNode node3 = new DLNode(30);
        DLNode node4 = new DLNode(

                40);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        head = reverse(head);
        while (head != null) {
            if (head.prev != null && head.next != null) {
                System.out.println("prev of " + head.data + " is " + head.prev.data);
                System.out.println("next of " + head.data + " is " + head.next.data);
            } else if (head.prev != null) {
                System.out.println("prev of " + head.data + " is " + head.prev.data);
            } else if (head.next != null) {
                System.out.println("next of " + head.data + " is " + head.next.data);
            } else {
                System.out.println("null");
            }
            head = head.next;
        }
    }

    public static DLNode reverse(DLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DLNode prevPointer = null;
        DLNode curr = head;
        while (curr != null) {
            curr.prev = curr.next;
            curr.next = prevPointer;
            prevPointer = curr;
            curr = curr.prev;
        }
        return prevPointer;
    }
}
