package com.dsagame.gfgselfpaced.linkedlist;

public class EndingInsertion {
    public static void main(String[] args) {
        SLNode head = insert((SLNode) null, 10);
        head = insert(head, 20);
        head = insert(head, 30);
        head = insert(head, 40);
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        SCLNode sclNode = insertEff(null, 10);
        sclNode = insertEff(sclNode, 20);
        sclNode = insertEff(sclNode, 30);
        sclNode = insertEff(sclNode, 40);

        SCLNode curr = sclNode;
        while (curr.next != sclNode) {
            System.out.println(curr.data);
            curr = curr.next;
        }

        DLNode dlNode = insert((DLNode) null, 10);
        dlNode = insert(dlNode, 20);
        dlNode = insert(dlNode, 30);
        dlNode = insert(dlNode, 40);
        while (dlNode != null) {
            if (dlNode.prev != null && dlNode.next != null) {
                System.out.println("prev of " + dlNode.data + " is " + dlNode.prev.data);
                System.out.println("next of " + dlNode.data + " is " + dlNode.next.data);
            } else if (dlNode.prev != null) {
                System.out.println("prev of " + dlNode.data + " is " + dlNode.prev.data);
            } else if (dlNode.next != null) {
                System.out.println("next of " + dlNode.data + " is " + dlNode.next.data);
            } else {
                System.out.println("null");
            }
            dlNode = dlNode.next;
        }
    }

    public static SLNode insert(SLNode head, int newNodeData) {
        if (head == null) {
            return new SLNode(newNodeData);
        }
        SLNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new SLNode(newNodeData);
        return head;
    }

    public static DLNode insert(DLNode head, int newNodeData) {
        if (head == null) {
            return new DLNode(newNodeData);
        }
        DLNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        DLNode newNode = new DLNode(newNodeData);
        curr.next = newNode;
        newNode.prev = curr;
        return head;
    }

    public static SCLNode insert(SCLNode head, int newNodeData) {
        if (head == null) {
            SCLNode newNode = new SCLNode(newNodeData);
            newNode.next = newNode;
            return newNode;
        }
        SCLNode newNode = new SCLNode(newNodeData);
        SCLNode curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
        return head;
    }

    public static SCLNode insertEff(SCLNode head, int newNodeData) {
        if (head == null) {
            SCLNode newNode = new SCLNode(newNodeData);
            newNode.next = newNode;
            return newNode;
        }
        SCLNode newNode = new SCLNode(head.data);
        newNode.next = head.next;
        head.data = newNodeData;
        head.next = newNode;
        return newNode;
    }
}
