package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class SortList {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode mid = mid(A);
        ListNode nextOfMid = mid.next;
        mid.next = null;
        ListNode leftList = sortList(A);
        ListNode rightList = sortList(nextOfMid);
        return merge(leftList, rightList);
    }

    public static ListNode mid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        ListNode left = null;
        if (head1.val <= head2.val) {
            left = head1;
            curr1 = curr1.next;
        } else {
            left = head2;
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
        if (curr1 != null) {
            left.next = curr1;
        }
        if (curr2 != null) {
            left.next = curr2;
        }
        return (head1.val <= head2.val) ? head1 : head2;
    }
}
