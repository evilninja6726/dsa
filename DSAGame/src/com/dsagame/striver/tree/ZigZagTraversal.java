package com.dsagame.striver.tree;

import java.util.*;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(zigzag(root));
    }

    public static List<List<Integer>> zigzag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean order = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                TreeNode front = queue.poll();
                level.add(front.data);
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            if (!order) {
                Collections.reverse(level);
            }
            res.add(level);
            order = !order;
        }
        return res;
    }
}
