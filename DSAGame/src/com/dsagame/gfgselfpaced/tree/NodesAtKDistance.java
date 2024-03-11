package com.dsagame.gfgselfpaced.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class NodesAtKDistance {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        treeNode.right.right = new TreeNode(60);
        // print(treeNode, 2);
        printItr(treeNode, 2);
    }

    public static void print(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.print(root.val + " ");
            return;
        }
        print(root.left, k - 1);
        print(root.right, k - 1);
    }

    public static void printItr(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.val);
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                TreeNode front = queue.poll();
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            if (k == 1) {
                while (!queue.isEmpty()) {
                    System.out.print(queue.poll().val + " ");
                }
                break;
            }
            k--;
        }
    }
}
