package com.dsagame.leetcode.tree.medium;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        treeNode.right.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        treeNode.right.right = new TreeNode(1);
        System.out.println(pathSum(treeNode, 5));
    }

    public static void helper(TreeNode root, int target, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && target - root.val == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            helper(root.left, target - root.val, path, res);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            helper(root.right, target - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(root, targetSum, path, res);
        return res;
    }
}
