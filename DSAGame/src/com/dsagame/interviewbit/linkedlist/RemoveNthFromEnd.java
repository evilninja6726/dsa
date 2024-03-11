package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode ListNode = new ListNode(1);
        ListNode.next = new ListNode(2);
        ListNode.next.next = new ListNode(3);
        ListNode.next.next.next = new ListNode(4);
        ListNode.next.next.next.next = new ListNode(5);
        ListNode.next.next.next.next.next = new ListNode(6);
        ListNode.next.next.next.next.next.next = new ListNode(7);
        ListNode = removeNthFromEnd(ListNode, 6);
        System.out.println(ListNode);
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if (A == null || A.next == null) {
            return null;
        }
        int length = 0;
        for (ListNode curr = A; curr != null; curr = curr.next) {
            length++;
        }
        System.out.println(length);
        if (B >= length) {
            return A.next;
        }
        ListNode curr = A;
        for (int i = 0; i < length - B - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return A;
    }
}
