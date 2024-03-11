package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class KthNodeFromMiddle {
    public static void main(String[] args) {

    }

    public static int solve(ListNode A, int B) {
        if (A == null || A.next == null) {
            return -1;
        }
        ListNode slow = A;
        ListNode fast = A;
        int length = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            length++;
        }
        if (B > length) {
            return -1;
        }
        slow.next = null;
        ListNode curr = A;
        for (int i = 0; i < length - B; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
}
