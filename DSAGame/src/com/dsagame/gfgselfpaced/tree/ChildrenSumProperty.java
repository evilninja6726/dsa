package com.dsagame.gfgselfpaced.tree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        System.out.println(property(treeNode));
    }

    public static boolean property(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftTree = property(root.left);
        boolean rightTree = property(root.right);
        if (root.left != null && root.right != null) {
            return leftTree && rightTree && (root.left.val + root.right.val == root.val);
        } else if (root.left != null) {
            return leftTree && rightTree && root.left.val == root.val;
        } else if (root.right != null) {
            return leftTree && rightTree && root.right.val == root.val;
        } else {
            return true;
        }
    }
}
