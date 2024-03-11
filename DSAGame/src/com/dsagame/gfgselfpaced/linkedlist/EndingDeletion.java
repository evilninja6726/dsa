package com.dsagame.gfgselfpaced.linkedlist;

public class EndingDeletion {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode = delete(slNode);
        while (slNode != null) {
            System.out.print(slNode.data + " ");
            slNode = slNode.next;
        }

        DLNode head = new DLNode(10);
        DLNode node2 = new DLNode(20);
        DLNode node3 = new DLNode(30);
        DLNode node4 = new DLNode(

                40);
        head.next = node2;
        node2.prev = head;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        head = delete(head);
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

    public static SLNode delete(SLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        SLNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    public static DLNode delete(DLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DLNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.prev.next = null;
        return head;
    }
}
