package com.dsagame.striver.linkedlist;

public class AddOne {
    public static void main(String[] args) {
//        Node head = new Node(1);
//        head.next = new Node(0);
//        head.next.next = new Node(1);
//        head.next.next.next = new Node(1);
//        head = addOne(head);
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }

        int res = 2;
        for (int i = 0; i <= 18; i++) {
            System.out.println(res *= 2);
        }

        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head = addOneRec(head);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node addOneRec(Node head) {
        int carry = helper(head);
        if (carry == 1) {
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public static int helper(Node head) {
        if (head == null) {
            return 1;
        }
        head.data += helper(head.next);
        if (head.data == 10) {
            head.data = 0;
            return 1;
        } else {
            return 0;
        }
    }

    public static Node addOne(Node head) {
        if (head == null) {
            return null;
        }
        head = reverse(head);
        int sum = 1;
        Node curr = head;
        while (curr.next != null) {
            sum += curr.data;
            if (sum == 10) {
                curr.data = 0;
                sum = 1;
            } else {
                curr.data = sum;
                sum = 0;
            }
            curr = curr.next;
        }
        sum += curr.data;
        if (sum == 10) {
            curr.data = 0;
            curr.next = new Node(1);
        } else {
            curr.data = sum;
        }
        return reverse(head);
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node left = null;
        Node curr = head;
        Node right = head;
        while (curr != null) {
            right = curr.next;
            curr.next = left;
            left = curr;
            curr = right;
        }
        return left;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
