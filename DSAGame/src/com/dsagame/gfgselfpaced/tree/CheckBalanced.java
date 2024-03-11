package com.dsagame.gfgselfpaced.tree;

public class CheckBalanced {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }

    public static int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTree = helper(root.left);
        if (leftTree == -1) {
            return -1;
        }
        int rightTree = helper(root.right);
        if (rightTree == -1) {
            return -1;
        }
        if (Math.abs(leftTree - rightTree) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftTree, rightTree);
        }
    }
}
