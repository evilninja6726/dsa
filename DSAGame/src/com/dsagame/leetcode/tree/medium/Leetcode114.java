package com.dsagame.leetcode.tree.medium;

import com.dsagame.leetcode.tree.TreeNode;

public class Leetcode114 {
    static TreeNode prev = null;

    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flattenItr(TreeNode root) {

    }
}
