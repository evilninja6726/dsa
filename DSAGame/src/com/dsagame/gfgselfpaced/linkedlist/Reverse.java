package com.dsagame.gfgselfpaced.linkedlist;

public class Reverse {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode = reverseTailRec(slNode, null);
        while (slNode != null) {
            System.out.println(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static SLNode reverseItr(SLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        SLNode left = null;
        SLNode curr = head;
        while (curr != null) {
            SLNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        return left;
    }

    public static SLNode reverseRec(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode restHead = reverseRec(head.next);
        SLNode restTail = head.next;
        head.next = null;
        restTail.next = head;
        return restHead;
    }

    public static SLNode reverseTailRec(SLNode head, SLNode left) {
        if (head == null) {
            return left;
        }
        SLNode right = head.next;
        head.next = left;
        return reverseTailRec(right, head);
    }
}
