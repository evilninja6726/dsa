package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode61 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node = rotateRight(node, 2);
        System.out.println(node);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode curr = head;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }
        if (k % length == 0) {
            return head;
        }
        k %= length;
        curr.next = head;
        curr = head;
        for (int i = 0; i < length - k - 1; i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;
        return head;
    }
}
