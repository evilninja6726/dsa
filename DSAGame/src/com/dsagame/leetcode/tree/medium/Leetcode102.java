package com.dsagame.leetcode.tree.medium;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Leetcode102 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> innerList = new ArrayList<>();
            int currLevelCount = queue.size();
            for (int i = 0; !queue.isEmpty() && i < currLevelCount; i++) {
                TreeNode front = queue.poll();
                innerList.add(front.val);
                if (front.left != null) {
                    queue.offer(front.left);
                }
                if (front.right != null) {
                    queue.offer(front.right);
                }
            }
            res.add(innerList);
        }
        return res;
    }
}
