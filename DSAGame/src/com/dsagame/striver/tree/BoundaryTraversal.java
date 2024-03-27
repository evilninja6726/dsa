package com.dsagame.striver.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root.left != null || root.right != null) {
            res.add(root.data);
        }
        addLeftBoundary(root, res);
        addLeafNodes(root, res);
        addRightBoundary(root, res);
        return res;
    }

    public static void addLeftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                res.add(curr.data);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void addLeafNodes(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.data);
        }
        addLeafNodes(root.left, res);
        addLeafNodes(root.right, res);
    }

    public static void addRightBoundary(TreeNode root, List<Integer> res) {
        List<Integer> rightBoundarySequence = new ArrayList<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (curr.right != null || curr.left != null) {
                rightBoundarySequence.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        Collections.reverse(rightBoundarySequence);
        res.addAll(rightBoundarySequence);
    }
}
