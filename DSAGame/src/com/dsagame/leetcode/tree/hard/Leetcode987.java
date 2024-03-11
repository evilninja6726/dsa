package com.dsagame.leetcode.tree.hard;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.*;

public class Leetcode987 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        HashMap<Integer, LevelValueList> map = new HashMap<>();
        Queue<DistanceNodePair> queue = new ArrayDeque<>();
        queue.offer(new DistanceNodePair(root, 0));
        int minVerticalLevel = 0;
        int maxVerticalLevel = 0;
        int horizontalLevel = 0;
        while (!queue.isEmpty()) {
            int currLevelCount = queue.size();
            for (int i = 0; !queue.isEmpty() && i < currLevelCount; i++) {
                DistanceNodePair front = queue.poll();
                minVerticalLevel = Math.min(front.horizontalDistance, minVerticalLevel);
                maxVerticalLevel = Math.max(front.horizontalDistance, maxVerticalLevel);
                if (map.containsKey(front.horizontalDistance)) {
                    LevelValueList levelValueList = map.get(front.horizontalDistance);
                    if (levelValueList.level == horizontalLevel && levelValueList.list.get(levelValueList.list.size() - 1) > front.node.val) {
                        int temp = levelValueList.list.get(levelValueList.list.size() - 1);
                        levelValueList.list.set(levelValueList.list.size() - 1, front.node.val);
                        levelValueList.list.add(temp);
                    } else {
                        levelValueList.list.add(front.node.val);
                    }
                    levelValueList.level = horizontalLevel;
                } else {
                    List<Integer> nestedList = new ArrayList<>();
                    nestedList.add(front.node.val);
                    LevelValueList levelValueList = new LevelValueList(horizontalLevel, nestedList);
                    map.put(front.horizontalDistance, levelValueList);
                }
                if (front.node.left != null) {
                    queue.offer(new DistanceNodePair(front.node.left, front.horizontalDistance - 1));
                }
                if (front.node.right != null) {
                    queue.offer(new DistanceNodePair(front.node.right, front.horizontalDistance + 1));
                }
            }
            horizontalLevel++;
        }
        for (int i = minVerticalLevel; i <= maxVerticalLevel; i++) {
            res.add(map.get(i).list);
        }
        return res;
    }
}

class LevelValueList {
    int level;
    List<Integer> list;

    public LevelValueList(int level, List<Integer> list) {
        this.level = level;
        this.list = list;
    }
}

class DistanceNodePair {
    TreeNode node;
    int horizontalDistance;

    public DistanceNodePair(TreeNode node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}
