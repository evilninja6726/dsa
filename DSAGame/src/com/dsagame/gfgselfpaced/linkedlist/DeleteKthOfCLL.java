package com.dsagame.gfgselfpaced.linkedlist;

public class DeleteKthOfCLL {
    public static void main(String[] args) {
        SCLNode sclNode = new SCLNode(10);
        sclNode.next = new SCLNode(20);
        sclNode.next.next = new SCLNode(30);
        sclNode.next.next.next = new SCLNode(40);
        sclNode.next.next.next.next = sclNode;

        sclNode = delete(sclNode, 1);
        SCLNode curr = sclNode;
        while (curr.next != sclNode) {
            System.out.println("szk: " + curr.data);
            curr = curr.next;
        }
    }

    public static SCLNode delete(SCLNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == head && k == 1) {
            return null;
        }
        if (k == 1) {
            head.data = head.next.data;
            head.next = head.next.next;
            return head;
        }
        SCLNode curr = head;
        for (int i = 0; i < k - 2; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
