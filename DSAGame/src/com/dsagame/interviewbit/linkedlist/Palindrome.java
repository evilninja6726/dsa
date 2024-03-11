package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Palindrome {
    public static void main(String[] args) {

    }

    public static int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reversedList = reverse(slow.next);
        slow.next = null;
        while (reversedList != null) {
            if (reversedList.val != A.val) {
                return 0;
            }
            reversedList = reversedList.next;
            A = A.next;
        }
        return 1;
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
