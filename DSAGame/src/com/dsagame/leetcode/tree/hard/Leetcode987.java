package com.dsagame.leetcode.tree.hard;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.*;

public class Leetcode987 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Triplet> queue = new ArrayDeque<>();
        queue.offer(new Triplet(root, 0, 0));
        while (!queue.isEmpty()) {
            Triplet front = queue.poll();
            TreeNode node = front.node;
            int x = front.x;
            int y = front.y;
            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.val);
            if (node.left != null) {
                queue.offer(new Triplet(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.offer(new Triplet(node.right, x + 1, y + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> levelMap : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : levelMap.values()) {
                while (!nodes.isEmpty()) {
                    res.get(res.size() - 1).add(nodes.poll());
                }
            }
        }
        return res;
    }

    private static class Triplet {
        TreeNode node;
        int x;
        int y;

        Triplet(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
}
