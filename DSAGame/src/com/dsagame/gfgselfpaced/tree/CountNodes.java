package com.dsagame.gfgselfpaced.tree;

public class CountNodes {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        System.out.println(count(treeNode));
    }

    public static int count(TreeNode root) {
        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode curr = root;
        while (curr != null) {
            leftHeight++;
            curr = curr.left;
        }
        curr = root;
        while (curr != null) {
            rightHeight++;
            curr = curr.right;
        }
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight) - 1);
        } else {
            return 1 + count(root.left) + count(root.right);
        }
    }
}
