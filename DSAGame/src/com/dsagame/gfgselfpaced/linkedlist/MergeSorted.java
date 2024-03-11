package com.dsagame.gfgselfpaced.linkedlist;

public class MergeSorted {
    public static void main(String[] args) {
        SLNode list1 = new SLNode(10);
        list1.next = new SLNode(20);
        list1.next.next = new SLNode(30);
        list1.next.next.next = new SLNode(40);
        list1.next.next.next.next = new SLNode(50);
        list1.next.next.next.next.next = new SLNode(60);
        list1.next.next.next.next.next.next = new SLNode(70);
        SLNode list2 = new SLNode(5);
        list2.next = new SLNode(15);
        list2.next.next = new SLNode(25);
        list2.next.next.next = new SLNode(75);
        list2.next.next.next.next = new SLNode(85);
        list1 = merge(list1, list2);
        while (list1 != null) {
            System.out.print(list1.data + " ");
            list1 = list1.next;
        }
    }

    public static SLNode merge(SLNode head1, SLNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        SLNode curr1;
        SLNode curr2;
        SLNode left;
        if (head1.data <= head2.data) {
            left = head1;
            curr1 = head1.next;
            curr2 = head2;
        } else {
            left = head2;
            curr2 = head2.next;
            curr1 = head1;
        }
        while (curr1 != null && curr2 != null) {
            if (curr1.data <= curr2.data) {
                left.next = curr1;
                left = curr1;
                curr1 = curr1.next;
            } else {
                left.next = curr2;
                left = curr2;
                curr2 = curr2.next;
            }
        }
        if (curr1 == null) {
            left.next = curr2;
        } else {
            left.next = curr1;
        }
        return (head1.data <= head2.data) ? head1 : head2;
    }
}
