package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode143 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        reorderList(node);
        System.out.println(node);
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedList = reverse(slow.next);
        System.out.println(reversedList);
        slow.next = null;
        ListNode curr = head;
        while (reversedList != null) {
            ListNode oldCurr = curr;
            ListNode oldFast = reversedList;
            curr = curr.next;
            oldCurr.next = reversedList;
            reversedList = reversedList.next;
            oldFast.next = curr;
        }
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
