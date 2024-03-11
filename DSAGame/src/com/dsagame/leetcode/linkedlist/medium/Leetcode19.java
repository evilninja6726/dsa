package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode19 {
    public static void main(String[] args) {
        ListNode slNode = new ListNode(10);
        slNode.next = new ListNode(20);
        slNode.next.next = new ListNode(30);
        slNode.next.next.next = new ListNode(40);
        slNode = removeNthFromEnd(slNode, 2);
        while (slNode != null) {
            System.out.println(slNode.val);
            slNode = slNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode first = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        ListNode prev = null;
        ListNode second = head;
        while (first != null) {
            first = first.next;
            prev = second;
            second = second.next;
        }
        if (prev == null) {
            return head.next;
        }
        prev.next = second.next;
        return prev;
    }
}
