package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class RemoveDuplicate {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode left = null;
        ListNode curr = A;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                left = curr;
                curr = curr.next;
            }
        }
        return A;
    }
}
