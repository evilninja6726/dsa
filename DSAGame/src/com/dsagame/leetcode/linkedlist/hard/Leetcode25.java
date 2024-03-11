package com.dsagame.leetcode.linkedlist.hard;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode25 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(10);
        listNode.next = new ListNode(20);
        listNode.next.next = new ListNode(30);
        listNode.next.next.next = new ListNode(40);
        listNode.next.next.next.next = new ListNode(50);
        listNode.next.next.next.next.next = new ListNode(60);
        // listNode.next.next.next.next.next.next = new ListNode(70);
        //listNode.next.next.next.next.next.next.next = new ListNode(80);
        listNode = reverseKGroup(listNode, 3);
        while (listNode != null) {
            System.out.println(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode curr = head;
        ListNode oldHead = null;
        boolean isFirstPass = true;
        while (curr != null) {
            ListNode left = null;
            ListNode oldCurr = curr;
            for (int i = 0; i < k && curr != null; i++) {
                ListNode right = curr.next;
                curr.next = left;
                left = curr;
                curr = right;
                if (curr == null && i != k - 1) {
                    curr = left;
                    left = null;
                    while (curr != null) {
                        right = curr.next;
                        curr.next = left;
                        left = curr;
                        curr = right;
                    }
                }
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
