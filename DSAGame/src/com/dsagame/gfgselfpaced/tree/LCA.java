package com.dsagame.gfgselfpaced.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        System.out.println(zigzag(root));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
        if (leftLCA == null) {
            return rightLCA;
        } else if (rightLCA == null) {
            return leftLCA;
        } else {
            return root;
        }
    }


    public static List<List<Integer>> zigzag(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                TreeNode front = queue.poll();
                list.add(front.val);
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            if (flag) {
                reverse(list);
            }
            res.add(list);
            flag = !flag;
        }
        return res;
    }

    public static void reverse(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            int temp = list.get(i);
            list.set(i++, list.get(j));
            list.set(j--, temp);
        }
    }
}
