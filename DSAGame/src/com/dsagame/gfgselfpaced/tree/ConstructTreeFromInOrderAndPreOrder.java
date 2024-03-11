package com.dsagame.gfgselfpaced.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInOrderAndPreOrder {
    int preIndex = 0;
    //     preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    int preorderIndex = 0;

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //return helper(preorder, inorder, 0, preorder.length - 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helperEff(preorder, inorder, 0, preorder.length - 1, map);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int i, int j) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int x;
        for (x = 0; x < preorder.length; x++) {
            if (inorder[x] == root.val) {
                break;
            }
        }
        root.left = helper(preorder, inorder, i, x - 1);
        root.right = helper(preorder, inorder, x + 1, j);
        return root;
    }

    public TreeNode helperEff(int[] preorder, int[] inorder, int i, int j, Map<Integer, Integer> map) {
        if (i > j) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        int index = map.get(root.val);
        root.left = helperEff(preorder, inorder, i, index - 1, map);
        root.right = helperEff(preorder, inorder, index + 1, j, map);
        return root;
    }
}
