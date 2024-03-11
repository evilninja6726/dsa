package com.dsagame.striver.linkedlist;

import java.util.Random;

public class BasicsOfDLL {
    public static void main(String[] args) {
        Node head = null;
        for (int i = 0; i < 10; i++) {
            head = addHead(head, i);
        }
        print(head);
        addTail(head, 11);
        print(head);
        head = deleteHead(head);
        print(head);
        head = deleteTail(head);
        print(head);
        head = deleteKth(head, 5);
        print(head);
        head = deleteKth(head, 1);
        head = deleteKth(head, 7);
        print(head);
        head = deleteKth(head, 8);
        print(head);
        head = deleteNode(head, 5);
        print(head);
        head = deleteNode(head, 7);
        head = deleteNode(head, 1);
        print(head);
        head = insertBeforeTail(head, 0);
        print(head);
        head = insertBeforeKth(head, 3, 8);
        print(head);
        for (int i = 0; i < 5; i++) {
            head = addHead(head, new Random().nextInt(11));
        }
        print(head);
        head = reverse(head);
        print(head);
    }


    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head, left = null;
        while (curr != null) {
            curr.prev = curr.next;
            curr.next = left;
            left = curr;
            curr = curr.prev;
        }
        return left;
    }

    public static Node insertBeforeKth(Node head, int k, int x) {
        if (k == 1) {
            return addHead(head, x);
        }
        Node curr = head;
        for (int i = 0; curr != null && i < k - 2; i++) {
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Not Possible");
            return head;
        } else if (curr.next == null) {
            addTail(head, x);
        } else {
            Node newNode = new Node(x);
            newNode.prev = curr;
            curr.next.prev = newNode;
            newNode.next = curr.next;
            curr.next = newNode;
        }
        return head;
    }

    public static Node insertBeforeTail(Node head, int x) {
        if (head == null) {
            return new Node(x);
        } else if (head.next == null) {
            return addHead(head, x);
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        Node newNode = new Node(x);
        newNode.prev = curr;
        curr.next.prev = newNode;
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

    public static Node deleteNode(Node head, int x) {
        if (head.data == x) {
            return deleteHead(head);
        }
        Node curr = head, left = null;
        while (curr != null && curr.data != x) {
            left = curr;
            curr = curr.next;
        }
        if (curr == null) {
            System.out.println("Not possible");
            return head;
        } else if (curr.next == null) {
            return deleteTail(head);
        } else {
            curr.next.prev = left;
            left.next = curr.next;
            curr.next = null;
            curr.prev = null;
            return head;
        }
    }

    public static Node deleteKth(Node head, int k) {
        if (head == null) {
            return null;
        } else if (k == 1) {
            return deleteHead(head);
        }
        Node curr = head;
        while (k-- != 2) {
            if (curr.next == null) {
                System.out.println("Not Possible");
                return head;
            }
            curr = curr.next;
        }
        if (curr.next.next == null) {
            return deleteTail(head);
        }
        curr.next.next.prev = curr;
        curr.next = curr.next.next;
        return head;
    }

    public static Node addHead(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }
        Node newHead = new Node(x);
        newHead.next = head;
        head.prev = newHead;
        return newHead;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        head.next.prev = null;
        return head.next;
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
        curr.next.prev = curr;
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
        curr.next.prev = null;
        curr.next = null;
        return head;
    }

    private static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }
}
