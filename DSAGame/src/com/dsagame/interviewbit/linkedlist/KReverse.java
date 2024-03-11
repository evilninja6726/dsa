package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class KReverse {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode A, int B) {
        if (A == null || A.next == null || B == 1) {
            return A;
        }
        ListNode curr = A;
        ListNode oldHead = null;
        boolean isFirstPass = true;
        while (curr != null) {
            ListNode oldCurr = curr;
            ListNode left = null;
            for (int i = 0; i < B; i++) {
                ListNode right = curr.next;
                curr.next = left;
                left = curr;
                curr = right;
            }
            if (isFirstPass) {
                A = left;
                isFirstPass = false;
            } else {
                oldHead.next = left;
            }
            oldHead = oldCurr;
        }
        return A;
    }
}
