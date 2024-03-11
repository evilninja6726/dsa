package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class ReverseAlternateKGroups {
    public static void main(String[] args) {
        ListNode ListNode = new ListNode(10);
        ListNode.next = new ListNode(20);
        ListNode.next.next = new ListNode(30);
        ListNode.next.next.next = new ListNode(40);
        ListNode.next.next.next.next = new ListNode(50);
        ListNode.next.next.next.next.next = new ListNode(60);
        ListNode.next.next.next.next.next.next = new ListNode(70);
        ListNode.next.next.next.next.next.next.next = new ListNode(80);
        ListNode.next.next.next.next.next.next.next.next = new ListNode(90);
        ListNode.next.next.next.next.next.next.next.next.next = new ListNode(100);
        ListNode = solve(ListNode, 2);
        while (ListNode != null) {
            System.out.println(ListNode.val);
            ListNode = ListNode.next;
        }
    }

    public static ListNode solve(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }
        boolean idOdd = true;
        boolean isFirstPass = true;
        ListNode curr = A;
        ListNode oldHead = null;
        while (curr != null) {
            if (!idOdd) {
                oldHead.next = curr;
                for (int i = 0; i < B; i++) {
                    oldHead = curr;
                    curr = curr.next;
                }
            } else {
                ListNode left = null;
                ListNode oldCurr = curr;
                for (int i = 0; i < B && curr != null; i++) {
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
            idOdd = !idOdd;
        }
        return A;
    }
}
