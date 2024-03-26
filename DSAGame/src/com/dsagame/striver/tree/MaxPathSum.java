package com.dsagame.striver.tree;

public class MaxPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root, res);
        return res[0];
    }

    public static int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left, res);
        int rightSum = helper(root.right, res);
        res[0] = Math.max(res[0], leftSum + rightSum + root.data);
        int ans = Math.max(leftSum, rightSum) + root.data;
        return Math.max(ans, 0);
    }
}
