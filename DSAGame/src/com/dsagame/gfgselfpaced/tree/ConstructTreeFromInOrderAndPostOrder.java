package com.dsagame.gfgselfpaced.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInOrderAndPostOrder {
    int postIndex = 0;

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    public static TreeNode helper(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> map) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int index = map.get(root.val);
        int numbersAtLeft = index - is;
        root.left = helper(inorder, postorder, is, index - 1, ps, ps + numbersAtLeft - 1, map);
        root.right = helper(inorder, postorder, index + 1, ie, ps + numbersAtLeft, pe - 1, map);
        return root;
    }
}
