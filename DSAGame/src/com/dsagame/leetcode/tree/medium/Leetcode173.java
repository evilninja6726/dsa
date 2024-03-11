package com.dsagame.leetcode.tree.medium;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.Stack;

public class Leetcode173 {
    public static void main(String[] args) {

    }
}

// BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        addAllLeftElements(root);
    }

    public void addAllLeftElements(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode top = stack.pop();
        addAllLeftElements(top.right);
        return top.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
