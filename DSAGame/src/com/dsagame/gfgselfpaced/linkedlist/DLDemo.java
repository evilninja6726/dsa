package com.dsagame.gfgselfpaced.linkedlist;

public class DLDemo {
    public static void main(String[] args) {
        DLNode head = new DLNode(10);
        head.prev = null;
        head.next = new DLNode(20);
        head.next.prev = head;
        head.next.next = new DLNode(30);
        head.next.next.prev = head.next;
        head.next.next.next = null;
        while (head != null) {
            if (head.prev != null && head.next != null) {
                System.out.println("prev of " + head.data + " is " + head.prev.data);
                System.out.println("next of " + head.data + " is " + head.next.data);
            } else if (head.prev != null) {
                System.out.println("prev of " + head.data + " is " + head.prev.data);
            } else if (head.next != null) {
                System.out.println("next of " + head.data + " is " + head.next.data);
            } else {
                System.out.println("null");
            }
            head = head.next;
        }
    }
}
