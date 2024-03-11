package com.dsagame.gfgselfpaced.bst;

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(15);
        treeNode.left = new TreeNode(10);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(18);
        treeNode.right.right = new TreeNode(30);
        System.out.println(treeNode);
        System.out.println(search(treeNode, 18));
    }

    public static boolean search(TreeNode root, int data) {
        if (root == null) {
            return false;
        } else if (root.val == data) {
            return true;
        } else {
            return search(root.left, data) || search(root.right, data);
        }
    }
}
