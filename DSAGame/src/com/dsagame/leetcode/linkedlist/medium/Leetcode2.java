package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode2 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode curr = new ListNode(-1);
        ListNode head = curr;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                curr.next = new ListNode(l2.val + carry);
                l2 = l2.next;
            } else if (l2 == null) {
                curr.next = new ListNode(l1.val + carry);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(l1.val + l2.val + carry);
                l1 = l1.next;
                l2 = l2.next;
            }
            curr = curr.next;
            if (curr.val >= 10) {
                carry = 1;
                curr.val %= 10;
            } else {
                carry = 0;
            }
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return head.next;
    }
}
