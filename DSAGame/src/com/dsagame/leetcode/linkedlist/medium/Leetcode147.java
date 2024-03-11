package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode147 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(0);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(0);
        node.next.next.next.next = new ListNode(0);
        node = insertionSortList(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        for (ListNode itr = head.next; itr != null; itr = itr.next) {
            ListNode left = null;
            ListNode curr = head;
            ListNode tail = curr;
            while (tail.next != itr) {
                tail = tail.next;
            }
            while (curr.val <= itr.val && curr.next != itr) {
                left = curr;
                curr = curr.next;
            }
            if (left == null && curr.val > itr.val) {
                tail.next = itr.next;
                tail = itr.next;
                ListNode newHead = new ListNode(itr.val);
                newHead.next = head;
                head = newHead;
            } else if (curr.next == itr) {
                if (curr.val > itr.val) {
                    tail.next = itr.next;
                    ListNode newNode = new ListNode(itr.val);
                    newNode.next = tail;
                    left.next = newNode;
                }
            } else {
                tail.next = itr.next;
                ListNode newNode = new ListNode(itr.val);
                newNode.next = left.next;
                left.next = newNode;
            }
        }
        return head;
    }
}
