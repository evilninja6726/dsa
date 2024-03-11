package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        System.out.println(sortList(head));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head, left = null;
        while (fast != null && fast.next != null) {
            left = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        left.next = null;
        head = merge(sortList(head), sortList(slow));
        return head;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode head;
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        if (curr1.val <= curr2.val) {
            head = curr1;
            curr1 = curr1.next;
        } else {
            head = curr2;
            curr2 = curr2.next;
        }
        ListNode left = head;
        while (true) {
            if (curr1 == null) {
                left.next = curr2;
                return head;
            } else if (curr2 == null) {
                left.next = curr1;
                return head;
            } else if (curr1.val <= curr2.val) {
                left.next = curr1;
                left = curr1;
                curr1 = curr1.next;
            } else {
                left.next = curr2;
                left = curr2;
                curr2 = curr2.next;
            }
        }
    }
}
