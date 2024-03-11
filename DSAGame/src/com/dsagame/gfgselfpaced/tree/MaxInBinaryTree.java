package com.dsagame.gfgselfpaced.tree;

public class MaxInBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        treeNode.right.right = new TreeNode(60);
        System.out.println(maxRec(treeNode));
    }

    public static int maxRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.val, Math.max(maxRec(root.left), maxRec(root.right)));
    }
}
