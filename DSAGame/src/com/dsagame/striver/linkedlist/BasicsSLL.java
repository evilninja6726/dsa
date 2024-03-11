package com.dsagame.striver.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class BasicsSLL {
    public static void main(String[] args) {
        Node head = null;
        for (int i = 0; i < 10; i++) {
            head = addTail(head, i);
        }
        System.out.println(length(head));
        System.out.println(convertToArray(head));
        System.out.println(find(head, 4));
        System.out.println(find(head, 47));
        print(head);
        head = reverse(head);
        print(head);
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " "
            );
            head = head.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node right = head.next;
        Node newHead = reverse(head.next);
        right.next = head;
        head.next = null;
        return newHead;
    }

    public static int length(Node head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }

    public static boolean find(Node head, int x) {
        if (head == null) {
            return false;
        }
        while (head != null) {
            if (head.data == x) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static Node addTail(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(x);
        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static Node addHead(Node head, int x) {
        Node newHead = new Node(x);
        newHead.next = head;
        return newHead;
    }

    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        return head.next;
    }

    public static List<Integer> convertToArray(Node head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.data);
            head = head.next;
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
