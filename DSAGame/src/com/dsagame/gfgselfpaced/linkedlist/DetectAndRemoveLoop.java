package com.dsagame.gfgselfpaced.linkedlist;

public class DetectAndRemoveLoop {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        //  slNode.next.next = slNode;
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode.next.next.next.next = new SLNode(50);
        slNode.next.next.next.next.next = new SLNode(60);
        slNode.next.next.next.next.next.next = new SLNode(70);
        slNode.next.next.next.next.next.next.next = new SLNode(80);
        slNode.next.next.next.next.next.next.next.next = slNode.next.next.next;
        detectAndRemove(slNode);
//        SLNode curr = slNode;
//        while (curr != null) {
//            System.out.println(curr.data + " ");
//            curr = curr.next;
//        }
        while (slNode != null) {
            System.out.println(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static void detectAndRemove(SLNode head) {
        SLNode slow = head;
        SLNode fast = head;
        boolean isLoop = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLoop = true;
                break;
            }
        }
        if (!isLoop) {
            return;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        SLNode curr = slow;
        while (curr.next != slow) {
            curr = curr.next;
        }
        curr.next = null;
    }
}
