package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class PairwiseSwap {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
        node = swapPairs(node);
        System.out.println(node);
    }

    public static ListNode swapPairs(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode curr = A.next.next;
        ListNode left = A;
        A = A.next;
        left.next = null;
        A.next = left;
        while (curr != null && curr.next != null) {
            left.next = curr.next;
            left = curr;
            ListNode right = curr.next.next;
            curr.next.next = curr;
            curr = right;
        }
        left.next = curr;
        return A;
    }
}
