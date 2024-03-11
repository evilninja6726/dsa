package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class SortBinaryList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(0);
        node = solve(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode curr = A;
        ListNode tail = A;
        ListNode tailStart = A;
        int zeroCount = 0;
        int oneCount = 0;
        while (tail.next != null) {
            if (tail.val == 0) {
                zeroCount++;
            } else if (tail.val == 1) {
                oneCount++;
            }
            tail = tail.next;
            tailStart = tailStart.next;
        }
        if (tail.val == 0) {
            zeroCount++;
        } else if (tail.val == 1) {
            oneCount++;
        }
        if (zeroCount == 0 || oneCount == 0) {
            return A;
        }
        ListNode left = null;
        while (A.val == 1) {
            A = A.next;
            curr = curr.next;
            tail.next = new ListNode(1);
            tail = tail.next;
        }
        while (curr != tailStart) {
            if (curr.val == 1) {
                left.next = curr.next;
                tail.next = new ListNode(1);
                tail = tail.next;
            } else {
                left = curr;
            }
            curr = curr.next;
        }
        return A;
    }
}
