package com.dsagame.leetcode.tree.medium;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1530 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        System.out.println(countPairs(treeNode, 3));
    }

    public static int countPairs(TreeNode root, int distance) {
        int[] res = new int[1];
        helper(root, distance, res);
        return res[0];
    }

    public static List<Integer> helper(TreeNode root, int distance, int[] res) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            return new ArrayList<>(List.of(1));
        }
        List<Integer> left = helper(root.left, distance, res);
        List<Integer> right = helper(root.right, distance, res);
        for (int li : left) {
            for (int ri : right) {
                if (li + ri <= distance) {
                    res[0]++;
                }
            }
        }
        List<Integer> rootLevelList = new ArrayList<>();
        for (int li : left) {
            if (li + 1 <= distance) {
                rootLevelList.add(li + 1);
            }
        }
        for (int ri : right) {
            if (ri + 1 <= distance) {
                rootLevelList.add(ri + 1);
            }
        }
        return rootLevelList;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
