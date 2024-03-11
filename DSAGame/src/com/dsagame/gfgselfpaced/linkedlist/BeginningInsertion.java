package com.dsagame.gfgselfpaced.linkedlist;

public class BeginningInsertion {
    public static void main(String[] args) {
//        SLNode head = insert((SLNode) null, 40);
//        head = insert(head, 30);
//        head = insert(head, 20);
//        head = insert(head, 10);
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }

        DLNode node1 = new DLNode(10);
        DLNode node2 = new DLNode(20);
        DLNode node3 = new DLNode(30);
        DLNode node4 = new DLNode(

                40);
        node1.next = node2;
        node2.prev = node1;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;

        DLNode head = insert((DLNode) null, 10);
        head = insert(head, 20);
        head = insert(head, 30);
        head = insert(head, 40);

        SCLNode sclNode = insertEff(null, 10);
        sclNode = insertEff(sclNode, 20);
        sclNode = insertEff(sclNode, 30);
        sclNode = insertEff(sclNode, 40);

        SCLNode curr = sclNode;
        while (curr.next != sclNode) {
            System.out.println(curr.data);
            curr = curr.next;
        }

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

    public static SLNode insert(SLNode head, int newHeadData) {
        SLNode newHead = new SLNode(newHeadData);
        newHead.next = head;
        return newHead;
    }

    public static DLNode insert(DLNode head, int newNodeData) {
        if (head == null) {
            return new DLNode(newNodeData);
        }
        DLNode newhead = new DLNode(newNodeData);
        head.prev = newhead;
        newhead.next = head;
        return newhead;
    }

    public static SCLNode insert(SCLNode head, int newNodeData) {
        if (head == null) {
            SCLNode newNode = new SCLNode(newNodeData);
            newNode.next = newNode;
            return newNode;
        }
        SCLNode newNode = new SCLNode(newNodeData);
        newNode.next = head;
        SCLNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        return newNode;
    }

    public static SCLNode insertEff(SCLNode head, int newNodeData) {    // O(1) Time
        if (head == null) {
            SCLNode newNode = new SCLNode(newNodeData);
            newNode.next = newNode;
            return newNode;
        }
        SCLNode newNode = new SCLNode(head.data);
        newNode.next = head.next;
        head.data = newNodeData;
        head.next = newNode;
        return head;
    }
}
