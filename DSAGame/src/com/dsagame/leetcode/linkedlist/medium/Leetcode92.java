package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode92 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        node = reverseBetween(node, 1, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        for (int i = 0; i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (prev == null) {
            ListNode next = curr.next;
            for (int i = 0; i < right - left; i++) {
                next = next.next;
                curr = curr.next;
            }
            curr.next = null;
            head = reverse(head);
            curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = next;
        } else {
            prev.next = null;
            ListNode oldCurr = curr;
            ListNode next = curr.next;
            for (int i = 0; i < right - left; i++) {
                next = next.next;
                curr = curr.next;
            }
            curr.next = null;
            oldCurr = reverse(oldCurr);
            prev.next = oldCurr;
            while (oldCurr.next != null) {
                oldCurr = oldCurr.next;
            }
            oldCurr.next = next;
        }
        return head;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        return left;
    }
}
