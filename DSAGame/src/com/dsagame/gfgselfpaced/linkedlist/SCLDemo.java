package com.dsagame.gfgselfpaced.linkedlist;

public class SCLDemo {
    public static void main(String[] args) {
        SCLNode sclNode = new SCLNode(10);
        sclNode.next = new SCLNode(20);
        sclNode.next.next = new SCLNode(30);
        sclNode.next.next.next = new SCLNode(40);
        sclNode.next.next.next.next = sclNode;
    }
}
