package com.dsagame.gfgselfpaced.tree;

public class ConvertTreeToDLL {
    static TreeNode prev;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(5);
        TreeNode res = convert(treeNode);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.right;
        }
    }

    public static TreeNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = convert(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        TreeNode rightTree = convert(root.right);
        return head;
    }
}
