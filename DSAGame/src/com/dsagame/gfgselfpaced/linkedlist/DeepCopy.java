package com.dsagame.gfgselfpaced.linkedlist;

import java.util.HashMap;

public class DeepCopy {
    public static void main(String[] args) {
        RandomNode node = new RandomNode(10);
        node.next = new RandomNode(20);
        node.next.next = new RandomNode(30);
        node.next.next.next = new RandomNode(40);
        node.randomNode = node.next.next;
        node.next.randomNode = node;
        node.next.next.randomNode = node;
        node.next.next.next.randomNode = node.next;
        RandomNode copyList = deepCopyEff(node);
        //System.out.println(copyList.next.next.next.randomNode.data);
        while (copyList != null && copyList.next != null) {
            System.out.println(copyList.data);
            System.out.println("next of " + copyList.data + " is " + copyList.next.data);
            System.out.println("random of " + copyList.data + " is " + copyList.randomNode.data);
            copyList = copyList.next;
        }

    }

    public static RandomNode deepCopy(RandomNode head) {
        HashMap<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode curr = head;
        while (curr != null) {
            map.put(curr, new RandomNode(curr.data));
            curr = curr.next;
        }
        curr = head;
        RandomNode newList;
        while (curr != null) {
            newList = map.get(curr);
            newList.next = map.get(curr.next);
            newList.randomNode = map.get(curr.randomNode);
            curr = curr.next;
        }
        return map.get(head);
    }

    public static RandomNode deepCopyEff(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode curr = head;
        while (curr != null) {
            RandomNode newNode = new RandomNode(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while (curr != null) {
            curr.next.randomNode = (curr.randomNode == null) ? null : curr.randomNode.next;
            curr = curr.next.next;
        }
        RandomNode newHead = head.next;
        curr = head;
        RandomNode clone = newHead;
        while (curr != null) {
            curr.next = curr.next.next;
            clone.next = (clone.next != null) ? clone.next.next : null;
            curr = curr.next;
            clone = clone.next;
        }
        return newHead;
    }
}

class RandomNode {
    int data;
    RandomNode next;
    RandomNode randomNode;

    public RandomNode(int data) {
        this.data = data;
        this.next = null;
        this.randomNode = null;
    }
}
