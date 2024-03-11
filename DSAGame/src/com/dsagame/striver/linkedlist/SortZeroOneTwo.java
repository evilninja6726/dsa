package com.dsagame.striver.linkedlist;

public class SortZeroOneTwo {
//    public static void main(String[] args) {
//        Node head = new Node(1);
//        head.next = new Node(2);
//        head.next.next = new Node(1);
//        head.next.next.next = new Node(0);
//        head.next.next.next.next = new Node(0);
//        head.next.next.next.next.next = new Node(1);
//        head.next.next.next.next.next.next = new Node(0);
//        head.next.next.next.next.next.next.next = new Node(2);
//        head.next.next.next.next.next.next.next.next = new Node(1);
//        head.next.next.next.next.next.next.next.next.next = new Node(0);
//        head.next.next.next.next.next.next.next.next.next.next = new Node(1);
//        head.next.next.next.next.next.next.next.next.next.next.next = new Node(2);
//        head.next.next.next.next.next.next.next.next.next.next.next.next = new Node(0);
//        head.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(1);
//        head.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new Node(2);
//        head = sort(head);
//        while (head != null) {
//            System.out.print(head.data + " ");
//            head = head.next;
//        }
//    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        Node head1 = new Node(1);
        head1.next = new Node(0);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(1);
        head1.next.next.next.next = new Node(0);
        printList(sort(head1));

        // Test Case 2
        Node head2 = new Node(0);
        head2.next = new Node(0);
        head2.next.next = new Node(0);
        printList(sort(head2));

        // Test Case 3
        Node head3 = new Node(1);
        head3.next = new Node(1);
        head3.next.next = new Node(1);
        printList(sort(head3));

        // Test Case 4
        Node head4 = new Node(2);
        head4.next = new Node(2);
        head4.next.next = new Node(2);
        printList(sort(head4));

        // Test Case 5
        Node head5 = new Node(0);
        head5.next = new Node(0);
        head5.next.next = new Node(2);
        head5.next.next.next = new Node(2);
        head5.next.next.next.next = new Node(0);
        printList(sort(head5));

        // Test Case 6
        Node head6 = new Node(1);
        head6.next = new Node(0);
        head6.next.next = new Node(1);
        head6.next.next.next = new Node(0);
        head6.next.next.next.next = new Node(1);
        printList(sort(head6));

        // Test Case 7
        Node head7 = new Node(1);
        head7.next = new Node(2);
        head7.next.next = new Node(2);
        head7.next.next.next = new Node(1);
        head7.next.next.next.next = new Node(2);
        printList(sort(head7));

        // Test Case 8
        Node head8 = new Node(1);
        head8.next = new Node(0);
        head8.next.next = new Node(2);
        head8.next.next.next = new Node(1);
        head8.next.next.next.next = new Node(0);
        head8.next.next.next.next.next = new Node(2);
        head8.next.next.next.next.next.next = new Node(0);
        printList(sort(head8));
    }


    public static Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zeroPtr = zeroHead;
        Node onePtr = oneHead;
        Node twoPtr = twoHead;
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zeroPtr = zeroPtr.next = curr;
            } else if (curr.data == 1) {
                onePtr = onePtr.next = curr;
            } else {
                twoPtr = twoPtr.next = curr;
            }
            curr = curr.next;
        }
        onePtr.next = twoHead.next;
        zeroPtr.next = oneHead.next;
        twoPtr.next = null;
        return zeroHead.next;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
