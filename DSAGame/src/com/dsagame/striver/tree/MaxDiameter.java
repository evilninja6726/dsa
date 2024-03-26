package com.dsagame.striver.tree;

public class MaxDiameter {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(maxDiameter(root));
    }

    public static int maxDiameter(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    public static int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left, res);
        int rightHeight = helper(root.right, res);
        res[0] = Math.max(res[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
