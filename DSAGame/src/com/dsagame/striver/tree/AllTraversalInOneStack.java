package com.dsagame.striver.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllTraversalInOneStack {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(dfs(root));
    }

    public static List<List<Integer>> dfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            if (top.order == 1) {
                preOrder.add(top.node.data);
                stack.push(new Pair(top.node, top.order + 1));
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            } else if (top.order == 2) {
                inOrder.add(top.node.data);
                stack.push(new Pair(top.node, top.order + 1));
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
            } else {
                postOrder.add(top.node.data);
            }
        }
        res.add(preOrder);
        res.add(inOrder);
        res.add(postOrder);
        return res;
    }

    private static class Pair {
        TreeNode node;
        int order;

        Pair(TreeNode node, int order) {
            this.node = node;
            this.order = order;
        }
    }
}
