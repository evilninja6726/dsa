package com.dsagame.interviewbit.linkedlist;

import com.dsagame.leetcode.linkedlist.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode num1 = new ListNode(5);
        num1.next = new ListNode(7);
//        num1.next.next = new ListNode(4);
//        num1.next.next.next = new ListNode(8);
//        num1.next.next.next.next = new ListNode(9);
        ListNode num2 = new ListNode(8);
        num2.next = new ListNode(9);
        num1 = addTwoNumbers(num1, num2);
        System.out.println(num1);
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (A == null && B == null) {
            return null;
        } else if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }
        ListNode curr1 = A;
        ListNode curr2 = B;
        int prevCarry = 0;
        ListNode left = null;
        while (curr1 != null && curr2 != null) {
            int sum = curr1.val + curr2.val + prevCarry;
            int nextCarry = sum / 10;
            sum %= 10;
            curr1.val = sum;
            prevCarry = nextCarry;
            left = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        if (curr1 == null && curr2 == null) {
            if (prevCarry > 0) {
                left.next = new ListNode(prevCarry);
            }
            return A;
        }
        if (curr1 == null) {
            left.next = curr2;
            curr1 = curr2;
        }
        while (curr1 != null) {
            int sum = prevCarry + curr1.val;
            int nextCarry = sum / 10;
            sum %= 10;
            curr1.val = sum;
            prevCarry = nextCarry;
            left = curr1;
            curr1 = curr1.next;
        }
        if (prevCarry > 0) {
            left.next = new ListNode(prevCarry);
        }
        return A;
    }
}
