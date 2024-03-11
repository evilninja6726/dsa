package com.dsagame.gfgselfpaced.tree;

public class Diameter {
    int res = 0;

    public static void main(String[] args) {

    }


    public int diameterOfBinaryTree(TreeNode root) {
        ResultWrapper resultWrapper = new ResultWrapper(0);
        helper(root, resultWrapper);
        return resultWrapper.result;
    }

    public int helper(TreeNode root, ResultWrapper resultWrapper) {
        if (root == null) {
            return 0;
        }
        int leftHeight = helper(root.left, resultWrapper);
        int rightHeight = helper(root.right, resultWrapper);
        resultWrapper.result = Math.max(resultWrapper.result, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left, diameter);
        int right = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return Math.max(left, right) + 1;

    }
}


class ResultWrapper {
    int result;

    ResultWrapper(int result) {
        this.result = result;
    }
}