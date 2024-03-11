package com.dsagame.sheet.lovebabbar.tree;

import java.util.*;

public class TopView {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        System.out.println(topView(node));
    }

    public static ArrayList<Integer> topView(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                Pair front = queue.poll();
                if (!map.containsKey(front.distance)) {
                    map.put(front.distance, front.node.data);
                }
                if (front.node.left != null) {
                    queue.offer(new Pair(front.node.left, front.distance - 1));
                }
                if (front.node.right != null) {
                    queue.offer(new Pair(front.node.right, front.distance + 1));
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}

class Pair {
    Node node;
    int distance;

    Pair(Node node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}
