package com.dsagame.gfgselfpaced.linkedlist;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        SLNode oddNode = new SLNode(10);
        oddNode.next = new SLNode(20);
        oddNode.next.next = new SLNode(30);
        oddNode.next.next.next = new SLNode(40);
        oddNode.next.next.next.next = new SLNode(30);
        oddNode.next.next.next.next.next = new SLNode(20);
        oddNode.next.next.next.next.next.next = new SLNode(10);

        SLNode evenNode = new SLNode(10);
        evenNode.next = new SLNode(20);
        evenNode.next.next = new SLNode(30);
        evenNode.next.next.next = new SLNode(30);
        evenNode.next.next.next.next = new SLNode(20);
        evenNode.next.next.next.next.next = new SLNode(10);
        // evenNode.next.next.next.next.next.next = new SLNode(10);
        System.out.println(isPalindrome(oddNode));
        System.out.println(isPalindrome(evenNode));
    }

    public static boolean isPalindromeUsingStack(SLNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        SLNode curr = head;
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }
        while (head != null) {
            if (stack.pop() != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome(SLNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        SLNode slow = head;
        SLNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = slow.next;


        slow = reverse(slow);
        SLNode curr = slow;
        while (curr != null) {
            curr = curr.next;
        }
        while (slow != null) {
            if (head.data != slow.data) {
                return false;
            }
            slow = slow.next;
            head = head.next;
        }
        if (fast == null) {
            return head.data == head.next.data;
        }
        return true;
    }

    public static SLNode reverse(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode left = null;
        SLNode curr = head;
        while (curr != null) {
            SLNode right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        return left;
    }
}
