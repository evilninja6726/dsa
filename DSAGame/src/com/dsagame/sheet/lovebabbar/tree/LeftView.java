package com.dsagame.sheet.lovebabbar.tree;

import java.util.ArrayList;

public class LeftView {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, 1, res);
        return res;
    }

    public static void helper(Node root, int currLevel, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        if (currLevel > res.size()) {
            res.add(root.data);
        }
        if (root.left != null) {
            helper(root.left, currLevel + 1, res);
        }
        if (root.right != null) {
            helper(root.right, currLevel + 1, res);
        }
    }
}
