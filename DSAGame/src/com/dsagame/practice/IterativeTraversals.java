package com.dsagame.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTraversals {
    public static void main(String[] args) {

    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (true) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else if (!stack.isEmpty()) {
                currNode = stack.pop();
                res.add(currNode.data);
                currNode = currNode.right;
            } else {
                break;
            }
        }
        return res;
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;
        while (true) {
            if (currNode != null) {
                res.add(currNode.data);
                stack.push(currNode);
                currNode = currNode.left;
            } else if (!stack.isEmpty()) {
                currNode = stack.pop();
                currNode = currNode.right;
            } else {
                break;
            }
        }
        return res;
    }
}

