package com.dsagame.gfgselfpaced.tree;

public class BurnTreeFromLeaf {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        System.out.println(calculateHeightAndSetDistance(treeNode, 5, 0, new Distance(-1)));
    }

    public static int minTime(TreeNode root, int target) {
        return calculateHeightAndSetDistance(root, target, 0, new Distance(-1));
    }


    public static int calculateHeightAndSetDistance(TreeNode root, int target, Integer res, Distance distance) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            distance.val = 0;
            return 1;
        }
        Distance leftDistance = new Distance(-1);
        Distance rightDistance = new Distance(-1);
        int leftHeight = calculateHeightAndSetDistance(root.left, target, res, leftDistance);
        int rightHeight = calculateHeightAndSetDistance(root.right, target, res, rightDistance);
        if (leftDistance.val != -1) {
            distance.val = leftDistance.val + 1;
            res = Math.max(res, distance.val + rightHeight);
        } else if (rightDistance.val != -1) {
            distance.val = rightDistance.val + 1;
            res = Math.max(res, distance.val + leftHeight);
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


class Distance {
    int val;

    public Distance(int val) {
        this.val = val;
    }
}