package com.dsagame.gfgselfpaced.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class SizeOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        treeNode.right.right = new TreeNode(60);
        System.out.println(sizeRec(treeNode));
        System.out.println(sizeItr(treeNode));
    }

    public static int sizeRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + sizeRec(root.left) + sizeRec(root.right);
    }

    public static int sizeItr(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            res++;
            if (front.left != null) {
                queue.offer(front.left);
            }
            if (front.right != null) {
                queue.offer(front.right);
            }
        }
        return res;
    }
}
