package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class MergeSorted {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null && B == null) {
            return null;
        } else if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }
        ListNode curr1 = A;
        ListNode curr2 = B;
        ListNode left;
        if (curr1.val <= curr2.val) {
            left = curr1;
            curr1 = curr1.next;
        } else {
            left = curr2;
            curr2 = curr2.next;
        }
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                left.next = curr1;
                left = curr1;
                curr1 = curr1.next;
            } else {
                left.next = curr2;
                left = curr2;
                curr2 = curr2.next;
            }
        }
        if (curr1 == null) {
            left.next = curr2;
        }
        if (curr2 == null) {
            left.next = curr1;
        }
        return (A.val <= B.val) ? A : B;
    }
}
