package com.dsagame.leetcode.tree.easy;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        System.out.println(binaryTreePaths(treeNode));
    }

    public static void helper(TreeNode root, String nodes, List<String> res) {
        if (root == null) {
            return;
        }
        nodes += root.val;
        if (root.left == null && root.right == null) {
            res.add(nodes);
        }
        nodes += "->";
        helper(root.left, nodes, res);
        helper(root.right, nodes, res);
    }


    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, "", res);
        return res;
    }
}
