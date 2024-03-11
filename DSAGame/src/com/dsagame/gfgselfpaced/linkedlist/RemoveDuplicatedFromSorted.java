package com.dsagame.gfgselfpaced.linkedlist;

public class RemoveDuplicatedFromSorted {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(20);
        slNode.next.next.next = new SLNode(40);
        slNode.next.next.next.next = new SLNode(40);
        slNode.next.next.next.next.next = new SLNode(40);
        slNode.next.next.next.next.next.next = new SLNode(50);
        slNode = removeDuplicated(slNode);
        while (slNode != null) {
            System.out.println(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static SLNode removeDuplicated(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode curr = head;
        while (curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
