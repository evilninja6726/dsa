package com.dsagame.striver.linkedlist;

public class LengthofLoop {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next.next.next.next = new Node(10);
        node.next.next.next.next.next.next.next.next.next.next = node.next.next.next;
        System.out.println(loopSize(node));
    }

    public static int loopSize(Node head) {
        if (head == null || head.next == null) {
            return -1;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return -1;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        fast = fast.next;
        int res = 1;
        while (slow != fast) {
            res++;
            fast = fast.next;
        }
        return res;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
