package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode82 {
    public static void main(String[] args) {
        ListNode ListNode = new ListNode(1);
        ListNode.next = new ListNode(1);
        ListNode.next.next = new ListNode(1);
        ListNode.next.next.next = new ListNode(2);
        ListNode.next.next.next.next = new ListNode(2);
//        ListNode.next.next.next.next.next = new ListNode(4);
//        ListNode.next.next.next.next.next.next = new ListNode(5);
//        ListNode.next.next.next.next.next.next.next = new ListNode(80);
//        ListNode.next.next.next.next.next.next.next.next = new ListNode(90);
//        ListNode.next.next.next.next.next.next.next.next.next = new ListNode(100);
        ListNode = deleteDuplicates(ListNode);
        System.out.println(ListNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        boolean isRemoved = false;
        ListNode left = null;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                isRemoved = true;
                curr.next = curr.next.next;
            } else {
                if (isRemoved) {
                    isRemoved = false;
                    if (left == null) {
                        head = curr.next;
                    } else {
                        left.next = curr.next;
                    }
                } else {
                    left = curr;
                }
                curr = curr.next;
            }
        }
        if (isRemoved) {
            if (left == null) {
                return null;
            } else {
                left.next = null;
            }
        }
        return head;
    }

}
