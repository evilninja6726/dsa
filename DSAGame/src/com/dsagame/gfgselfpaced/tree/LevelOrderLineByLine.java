package com.dsagame.gfgselfpaced.tree;


import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderLineByLine {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        treeNode.right.right = new TreeNode(60);
        levelOrder(treeNode);
    }

    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                TreeNode front = queue.poll();
                System.out.print(front.val + " ");
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
