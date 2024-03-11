package com.dsagame.gfgselfpaced.linkedlist;

public class DeleteNodeWithoutHead {
    public static void main(String[] args) {
        SLNode slNode = new SLNode(10);
        slNode.next = new SLNode(20);
        //  slNode.next.next = slNode;
        slNode.next.next = new SLNode(30);
        slNode.next.next.next = new SLNode(40);
        slNode.next.next.next.next = new SLNode(50);
        slNode.next.next.next.next.next = new SLNode(60);
        slNode.next.next.next.next.next.next = new SLNode(70);
        slNode.next.next.next.next.next.next.next = new SLNode(80);
        delete(slNode);
        delete(slNode.next.next.next.next);
        delete(slNode.next.next.next.next.next);
        while (slNode != null) {
            System.out.print(slNode.data + " ");
            slNode = slNode.next;
        }
    }

    public static void delete(SLNode nodeToBeDeleted) {
        if (nodeToBeDeleted.next == null) {
            return;
        }
        nodeToBeDeleted.data = nodeToBeDeleted.next.data;
        nodeToBeDeleted.next = nodeToBeDeleted.next.next;
    }
}
