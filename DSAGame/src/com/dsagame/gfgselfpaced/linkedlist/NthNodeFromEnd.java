package com.dsagame.gfgselfpaced.linkedlist;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        System.out.println(nthNodeUsingTwoPointers(null, 4));
        System.out.println(nthNodeUsingTwoPointers(slNode, 0));
        System.out.println(nthNodeUsingTwoPointers(slNode, 1));
        System.out.println(nthNodeUsingTwoPointers(slNode, 2));
        System.out.println(nthNodeUsingTwoPointers(slNode, 3));
        System.out.println(nthNodeUsingTwoPointers(slNode, 4));
        System.out.println(nthNodeUsingTwoPointers(slNode, 6));
    }

    public static int nthNode(SLNode head, int n) {
        if (head == null || n < 1) {
            return -1;
        }
        SLNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        if (n > length) {
            return -1;
        }
        curr = head;
        for (int i = 0; i < length - n; i++) {
            curr = curr.next;
        }
        return curr.data;
    }

    public static int nthNodeUsingTwoPointers(SLNode head, int n) {
        if (head == null || n < 1) {
            return -1;
        }
        SLNode first = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                return -1;
            }
            first = first.next;
        }
        SLNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second.data;
    }
}
