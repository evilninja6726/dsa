package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class EvenReverse {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node = solve(node);
        System.out.println(node);
    }

    public static ListNode solve(ListNode A) {
        if (A == null || A.next == null || A.next.next == null) {
            return A;
        }
        ListNode reversedList = A.next;
        ListNode curr1 = A;
        ListNode curr2 = A.next;
        while (curr2 != null && curr2.next != null) {
            curr1.next = curr2.next;
            curr1 = curr2.next;
            curr2.next = curr1.next;
            curr2 = curr1.next;
        }
        if (curr2 != null) {
            curr1.next = null;
        }
        curr2 = reverse(reversedList);
        curr1 = A;
        while (curr2 != null) {
            ListNode oldCurr1 = curr1;
            ListNode oldCurr2 = curr2;
            curr1 = curr1.next;
            oldCurr1.next = curr2;
            curr2 = curr2.next;
            oldCurr2.next = curr1;
        }
        return A;
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
