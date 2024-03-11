package com.dsagame.striver.linkedlist;

import java.util.*;

public class PairWithGivenSumInDLL {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 2, 1, 3, 4, 5, 3, 2, 4, 2, 3, 1};
        Node head = null;
        for (int val : values) {
            head = addToHead(head, val);
        }
        List<int[]> res = pairWithGivenSum(head, 7);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<int[]> pairWithGivenSum(Node head, int x) {
        List<int[]> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            if (set.contains(x - curr.data)) {
                res.add(new int[]{curr.data, x - curr.data});
            }
            curr = curr.next;
        }
        return res;
    }

    public static Node addToHead(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }
        Node newHead = new Node(x);
        newHead.next = head;
        head.prev = newHead;
        return newHead;
    }

    private static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }
}
