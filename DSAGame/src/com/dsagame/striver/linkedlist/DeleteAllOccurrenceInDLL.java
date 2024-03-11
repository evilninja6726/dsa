package com.dsagame.striver.linkedlist;

public class DeleteAllOccurrenceInDLL {
    public static void main(String[] args) {

    }

    public static Node delete(Node head, int x) {
        if (head == null) {
            return null;
        }
        Node curr = head, left = head;
        while (curr != null) {
            if (curr.data == x) {
                left.next = curr.next;
                curr.next.prev = left;
            } else {
                left = curr;
            }
            curr = curr.next;
        }
        if (head.data == x) {
            return head.next;
        }
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
