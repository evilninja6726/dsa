package com.dsagame.gfgselfpaced.linkedlist;

public class Searching {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);

        System.out.println(searchRec(slNode, 11));
        System.out.println(searchRec(slNode, 30));
    }

    public static int search(SLNode head, int item) {
        if (head == null || (head.data != item && head.next == null)) {
            return -1;
        }
        int position = 1;
        while (head != null) {
            if (head.data == item) {
                return position;
            }
            head = head.next;
            position++;
        }
        return -1;
    }

    public static int searchRec(SLNode head, int item) {
        if (head == null) {
            return -1;
        }
        if (head.data == item) {
            return 1;
        } else {
            int res = searchRec(head.next, item);
            return (res == -1) ? -1 : res + 1;
        }
    }
}
