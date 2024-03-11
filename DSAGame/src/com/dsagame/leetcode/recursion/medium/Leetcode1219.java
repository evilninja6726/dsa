package com.dsagame.leetcode.recursion.medium;

public class Leetcode1219 {
    // static int max = 0;

    public static void main(String[] args) {
        //[[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        System.out.println(getMaximumGold(new int[][]{
                {1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}
        }));
    }

    public static int getMaximumGold(int[][] grid) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int[] max = new int[1];
        return helper(grid, 0, 0, 0, isVisited, max);
    }

    public static int helper(int[][] grid, int row, int column, int curr, boolean[][] isVisited, int[] max) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!isVisited[row][column] && grid[i][j] != 0) {
                    int sum = 0;
                    collectGold(grid, i, j, sum, isVisited, max);
                }
            }
        }
        return max[0];
    }

    public static void collectGold(int[][] grid, int row, int column, int sum, boolean[][] isVisited, int[] max) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || isVisited[row][column] || grid[row][column] == 0) {
            return;
        }
        isVisited[row][column] = true;
        sum += grid[row][column];
        collectGold(grid, row, column - 1, sum, isVisited, max);
        collectGold(grid, row, column + 1, sum, isVisited, max);
        collectGold(grid, row - 1, column, sum, isVisited, max);
        collectGold(grid, row + 1, column, sum, isVisited, max);
        max[0] = Math.max(max[0], sum);
        isVisited[row][column] = false;
        sum -= grid[row][column];
    }
}
