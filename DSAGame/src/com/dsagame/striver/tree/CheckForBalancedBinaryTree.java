package com.dsagame.striver.tree;

public class CheckForBalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.right.left = new TreeNode(8);
        root.left.right.left.left = new TreeNode(8);
        System.out.println(checkBalanced(root));
    }

    public static int checkBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = checkBalanced(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkBalanced(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
