package com.dsagame.leetcode.linkedlist.medium;

import com.dsagame.leetcode.linkedlist.ListNode;

public class Leetcode725 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        curr = head;
        int i = 0;
        if (length <= k) {
            while (curr != null) {
                res[i] = curr;
                curr = curr.next;
                res[i++].next = null;
            }
            for (int x = i; x < k; x++) {
                res[x] = null;
            }
            return res;
        }
        int quotient = length / k;
        int remainder = length % k;
        for (i = 0; i < k; i++) {
            ListNode subList = curr;
            ListNode left = null;
            if (remainder-- > 0) {
                for (int j = 0; j < quotient + 1; j++) {
                    left = curr;
                    curr = curr.next;
                }
            } else {
                for (int j = 0; j < quotient; j++) {
                    left = curr;
                    curr = curr.next;
                }
            }
            left.next = null;
            res[i] = subList;
        }
        return res;
    }
}
