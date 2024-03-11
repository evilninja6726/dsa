package com.dsagame.gfgextras.tree;

import com.dsagame.gfgselfpaced.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class NodesAtKLevel {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        System.out.println(nodesAtKLevel(treeNode, 3));
    }

    public static List<Integer> nodesAtKLevel(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        helper(root, 3, res);
        return res;
    }

    public static void helper(TreeNode root, int k, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (k == 1) {
            res.add(root.val);
        }
        helper(root.left, k - 1, res);
        helper(root.right, k - 1, res);
    }
}
