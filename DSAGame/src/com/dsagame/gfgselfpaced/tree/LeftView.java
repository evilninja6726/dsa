package com.dsagame.gfgselfpaced.tree;

import java.util.ArrayList;
import java.util.List;

public class LeftView {
    static int maxLevel = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        // treeNode.left.left = new TreeNode(40);
        //  treeNode.left.right = new TreeNode(50);
        treeNode.right.right = new TreeNode(60);
        System.out.println(leftViewRec(treeNode, new ArrayList<>(), 1));
    }

    public static List<Integer> leftViewRec(TreeNode root, List<Integer> res, int currLevel) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (currLevel > maxLevel) {
            res.add(root.val);
            maxLevel = currLevel;
        }
        if (root.left != null) {
            leftViewRec(root.left, res, currLevel + 1);
        }
        if (root.right != null) {
            leftViewRec(root.right, res, currLevel + 1);
        }
        return res;
    }
}
