package com.dsagame.leetcode.tree.medium;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode662 {
    public static void main(String[] args) {

    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, 0));
        int res = 0;
        while (!queue.isEmpty()) {
            int leftMostIndex = queue.peek().index;
            int rightMostIndex = leftMostIndex;
            int size = queue.size();
            for (int i = 0; !queue.isEmpty() && i < size; i++) {
                Pair front = queue.poll();
                rightMostIndex = front.index;
                if (front.node.left != null) {
                    queue.offer(new Pair(front.node.left, 2 * front.index + 1));
                }
                if (front.node.right != null) {
                    queue.offer(new Pair(front.node.right, 2 * front.index + 2));
                }
            }
            res = Math.max(res, rightMostIndex - leftMostIndex + 1);
        }
        return res;
    }
}

class Pair {
    TreeNode node;
    Integer index;

    public Pair(TreeNode node, Integer index) {
        this.node = node;
        this.index = index;
    }
}
