package com.dsagame.striver.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        levelOrderTraversal(root);
        System.out.println();
        levelOrderLineByLineTraversal(root);
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.print(front.data + " ");
            if (front.left != null) {
                queue.offer(front.left);
            }
            if (front.right != null) {
                queue.offer(front.right);
            }
        }
    }

    public static void levelOrderLineByLineTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                System.out.print(front.data + " ");
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            System.out.println();
        }
    }
}
