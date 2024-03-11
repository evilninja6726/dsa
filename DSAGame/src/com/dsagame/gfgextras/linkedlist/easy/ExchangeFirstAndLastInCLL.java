package com.dsagame.gfgextras.linkedlist.easy;

import com.dsagame.gfgextras.linkedlist.SCLNode;

public class ExchangeFirstAndLastInCLL {
    public static void main(String[] args) {
        SCLNode node = new SCLNode(10);
        node.next = new SCLNode(20);
        node.next.next = new SCLNode(30);
        node.next.next.next = new SCLNode(40);
        node.next.next.next.next = node;
        node = exchange(node);
        SCLNode curr = node;
        while (curr.next != node) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println(curr.data);
    }

    public static SCLNode exchange(SCLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SCLNode curr = head;
        while (curr.next.next != head) {
            curr = curr.next;
        }
        curr.next.next = head.next;
        head.next = curr.next;
        curr.next = head;
        return curr.next.next;
    }
}
