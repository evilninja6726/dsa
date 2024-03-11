package com.dsagame.gfgselfpaced.linkedlist;

public class PairwiseSwap {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(5);
        slNode.next = new SLNode(10);
        slNode.next.next = new SLNode(15);
        slNode.next.next.next = new SLNode(20);
        slNode.next.next.next.next = new SLNode(25);
        slNode.next.next.next.next.next = new SLNode(30);
        slNode.next.next.next.next.next.next = new SLNode(35);
        // slNode.next.next.next.next.next.next.next = new SLNode(40);
        slNode = swapNodesItr(slNode);
        while (slNode != null) {
            System.out.print(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static SLNode swapData(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode curr = head;
        while (curr != null && curr.next != null) {
            int currData = curr.data;
            curr.data = curr.next.data;
            curr.next.data = currData;
            curr = curr.next.next;
        }
        return head;
    }

    public static SLNode swapNodes(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode restHead = swapNodes(head.next.next);
        SLNode res = head.next;
        head.next.next = head;
        head.next = restHead;
        return res;
    }

    public static SLNode swapNodesItr(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode curr = head.next.next;
        SLNode left = head;
        head = head.next;
        head.next = left;
        while (curr != null && curr.next != null) {
            left.next = curr.next;
            left = curr;
            SLNode right = curr.next.next;
            curr.next.next = curr;
            curr = right;
        }
        left.next = curr;
        return head;
    }
}
