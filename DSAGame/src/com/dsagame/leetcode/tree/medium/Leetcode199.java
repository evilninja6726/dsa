package com.dsagame.leetcode.tree.medium;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode199 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        //  treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(40);
        treeNode.left.right = new TreeNode(50);
        // treeNode.right.right = new TreeNode(60);
        System.out.println(rightSideView(treeNode));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, 1, res);
        return res;
    }

    public static void helper(TreeNode root, int currLevel, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (currLevel > res.size()) {
            res.add(root.val);
        }
        if (root.right != null) {
            helper(root.right, currLevel + 1, res);
        }
        if (root.left != null) {
            helper(root.left, currLevel + 1, res);
        }
    }
}
