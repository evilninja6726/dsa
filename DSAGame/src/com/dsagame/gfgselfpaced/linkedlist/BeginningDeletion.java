package com.dsagame.gfgselfpaced.linkedlist;

public class BeginningDeletion {
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

        SCLNode sclNode = new SCLNode(10);
        sclNode.next = new SCLNode(20);
        sclNode.next.next = new SCLNode(30);
        sclNode.next.next.next = new SCLNode(40);
        sclNode.next.next.next.next = sclNode;

        sclNode = deleteEff(sclNode);
        SCLNode curr = sclNode;
        while (curr.next != sclNode) {
            System.out.println("szk: " + curr.data);
            curr = curr.next;
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
        return head.next;
    }

    public static DLNode delete(DLNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        head.next.prev = null;
        return head.next;
    }

    public static SCLNode delete(SCLNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        SCLNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = head.next;
        return head.next;
    }

    public static SCLNode deleteEff(SCLNode head) {
        if (head == null || head.next == head) {
            return null;
        }
        head.data = head.next.data;
        head.next = head.next.next;
        return head;
    }
}
