package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode86 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);

//        ListNode node = new ListNode(2);
//        node.next = new ListNode(1);
        node = partition(node, 3);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode left = null;
        while (curr != null) {
            if (curr.val >= x) {
                break;
            } else {
                left = curr;
                curr = curr.next;
            }
        }
        if (curr == null || curr.next == null) {
            return head;
        }
        ListNode sortedList = (left == null) ? null : head;
        head = curr;
        ListNode sortedItr = sortedList;
        while (sortedItr != null && sortedItr.next != curr) {
            sortedItr = sortedItr.next;
        }
        if (left != null) {
            left.next = null;
        }
        left = null;
        while (curr != null) {
            if (curr.val < x) {
                if (sortedItr == null) {
                    sortedList = new ListNode(curr.val);
                    sortedItr = sortedList;
                } else {
                    sortedItr.next = curr;
                    sortedItr = sortedItr.next;
                }
                left.next = curr.next;
            } else {
                left = curr;
            }
            curr = curr.next;
        }
        if (sortedItr == null) {
            return head;
        }
        sortedItr.next = head;
        return sortedList;
    }
}
