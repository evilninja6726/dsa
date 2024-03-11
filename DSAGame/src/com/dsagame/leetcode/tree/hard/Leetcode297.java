package com.dsagame.leetcode.tree.hard;

import com.dsagame.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(8);
//        root.right.left.right = new TreeNode(9);
//        root.left.right.right = new TreeNode(10);
        StringBuilder res = new StringBuilder();
        encodeHelper(root, res);
        System.out.println(res);
        root = deserialize(res.toString());
        System.out.println(root);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder serializedString = new StringBuilder();
        encodeHelper(root, serializedString);
        return serializedString.toString();
    }

    public static void encodeHelper(TreeNode root, StringBuilder serializedString) {
        if (root == null) {
            serializedString.append("null").append(",");
            return;
        }
        serializedString.append(root.val).append(",");
        encodeHelper(root.left, serializedString);
        encodeHelper(root.right, serializedString);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> nodes = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return decodeHelper(nodes);
    }

    public static TreeNode decodeHelper(Queue<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String front = nodes.poll();
        TreeNode root = null;
        if (!front.equals("null")) {
            root = new TreeNode(Integer.parseInt(front));
            root.left = decodeHelper(nodes);
            root.right = decodeHelper(nodes);
        }
        return root;
    }
}
