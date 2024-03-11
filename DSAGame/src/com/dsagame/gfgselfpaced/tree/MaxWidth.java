package com.dsagame.gfgselfpaced.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxWidth {
    public static void main(String[] args) {

    }

    public static int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = Math.max(res, size);
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                TreeNode front = queue.poll();
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
        }
        return res;
    }
}
