package com.dsagame.gfgselfpaced.linkedlist;

public class ReverseInGroupsOfK {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode.next.next.next.next = new SLNode(50);
        slNode.next.next.next.next.next = new SLNode(60);
        slNode.next.next.next.next.next.next = new SLNode(70);
        slNode.next.next.next.next.next.next.next = new SLNode(80);
        slNode = reverseItr(slNode, 3);
        while (slNode != null) {
            System.out.println(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static SLNode reverseRec(SLNode head, int k) {
        SLNode left = null;
        SLNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            SLNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        if (curr != null) {
            head.next = reverseRec(curr, k);
        }
        return left;
    }

    public static SLNode reverseItr(SLNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode curr = head;
        SLNode oldHead = null;
        boolean isFirstPass = true;
        while (curr != null) {
            SLNode left = null;
            SLNode oldCurr = curr;
            for (int i = 0; i < k && curr != null; i++) {
                SLNode right = curr.next;
                curr.next = left;
                left = curr;
                curr = right;
            }
            if (isFirstPass) {
                head = left;
                isFirstPass = false;
            } else {
                oldHead.next = left;
            }
            oldHead = oldCurr;
        }
        return head;
    }
}
