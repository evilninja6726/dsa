package com.dsagame.gfgselfpaced.linkedlist;

public class SegregateEvenOdd {
    public static void main(String[] args) {
//        SLNode slNode = new SLNode(5);
//        slNode.next = new SLNode(10);
//        slNode.next.next = new SLNode(15);
//        slNode.next.next.next = new SLNode(20);
//        slNode.next.next.next.next = new SLNode(25);
//        slNode.next.next.next.next.next = new SLNode(30);
//        slNode.next.next.next.next.next.next = new SLNode(35);
//        slNode.next.next.next.next.next.next.next = new SLNode(40);
        SLNode slNode = new SLNode(17);
        slNode.next = new SLNode(15);
        slNode.next.next = new SLNode(8);
        slNode.next.next.next = new SLNode(9);
        slNode.next.next.next.next = new SLNode(2);
        slNode.next.next.next.next.next = new SLNode(4);
        slNode.next.next.next.next.next.next = new SLNode(6);
        //  slNode.next.next.next.next.next.next.next = new SLNode(40);

        //17 15 8 9 2 4 6
        slNode = segregate(slNode);
        while (slNode != null) {
            System.out.print(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static SLNode segregate(SLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SLNode evenStart = null;
        SLNode evenEnd = null;
        SLNode oddStart = null;
        SLNode oddEnd = null;
        SLNode curr = head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = curr;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }

            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = curr;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        //System.out.println(oddStart.data);
        if (oddStart == null || evenStart == null) {
            return head;
        } else {
            evenEnd.next = oddStart;
            oddEnd.next = null;
            return evenStart;
        }
    }
}
