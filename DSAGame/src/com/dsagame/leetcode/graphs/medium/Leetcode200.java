package com.dsagame.leetcode.graphs.medium;

public class Leetcode200 {
    public static void main(String[] args) {

    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    helper(grid, i, j, isVisited);
                    res++;
                }
            }
        }
        return res;
    }

    public static void helper(char[][] arr, int i, int j, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == '0' || isVisited[i][j]) {
            return;
        }
        isVisited[i][j] = true;
        helper(arr, i - 1, j, isVisited);
        helper(arr, i, j + 1, isVisited);
        helper(arr, i + 1, j, isVisited);
        helper(arr, i, j - 1, isVisited);
    }
}
