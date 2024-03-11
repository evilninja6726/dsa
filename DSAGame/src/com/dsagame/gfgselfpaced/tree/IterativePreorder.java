package com.dsagame.gfgselfpaced.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorder {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        System.out.println(preorder(treeNode));
        System.out.println(preorderSpaceOpt(treeNode));
    }

    public static List<Integer> preorder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }

    public static List<Integer> preorderSpaceOpt(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                res.add(curr.val);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
        return res;
    }
}
