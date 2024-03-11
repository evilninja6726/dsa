package com.dsagame.sheet.lovebabbar.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.right.left = new Node(50);
        root.left.right = new Node(60);
        root.right.right = new Node(70);
        System.out.println(reverseLevelOrder(root));
    }

    public static ArrayList<Integer> reverseLevelOrder(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        Queue<Node> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            stack.push(front.data);
            if (front.right != null) {
                queue.offer(front.right);
            }
            if (front.left != null) {
                queue.offer(front.left);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
