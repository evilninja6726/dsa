package com.dsagame.gfgselfpaced.linkedlist;

public class DetectLoop {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        // slNode.next.next = slNode;
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode.next.next.next.next = new SLNode(50);
        slNode.next.next.next.next.next = new SLNode(60);
        slNode.next.next.next.next.next.next = new SLNode(70);
        slNode.next.next.next.next.next.next.next = new SLNode(80);
        slNode.next.next.next.next.next.next.next = slNode.next.next.next;
        System.out.println(detectLoop(slNode));
    }

    public static boolean detectLoop(SLNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        SLNode slow = head;
        SLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
