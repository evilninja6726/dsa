package com.dsagame.gfgselfpaced.linkedlist;

public class PrintMiddle {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        // slNode.next = new SLNode(20);
        // slNode.next.next = new SLNode(30);
        //slNode.next.next.next = new SLNode(40);
        System.out.println(print(null));
    }

    public static int print(SLNode head) {
        if (head == null) {
            return -1;
        }
        SLNode slow = head;
        SLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
