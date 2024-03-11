package com.dsagame.leetcode.graphs.medium;

import java.util.Arrays;

public class Leetcode1034 {
    static public int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] twoDArray = {
                {2, 3, 4, 3, 1},
                {4, 2, 2, 2, 1},
                {1, 2, 2, 2, 1},
                {5, 2, 2, 2, 1},
                {6, 7, 0, 1, 1}
        };
        int[][] res = colorBorder(twoDArray, 1, 1, 3);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }

        int[][] allOnesArray = new int[10][10];

        // Initialize all elements to 1
        for (int[] ints : allOnesArray) {
            Arrays.fill(ints, 1);
        }

        int[][] ans = colorBorder(allOnesArray, 0, 0, 3);
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

//    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
//        int n = grid.length;
//        int m = grid[0].length;
//
//        if (grid[row][col] == color)
//            return grid;
//
//        boolean[][] visited = new boolean[n][m];
//        dfs(grid, row, col, grid[row][col], visited, color, n, m);
//
//        return grid;
//    }

//    static void dfs(int[][] grid, int i, int j, int oldColor, boolean[][] visited, int targetColor, int n, int m) {
//        if (i >= n || i < 0 || j < 0 || j >= m || grid[i][j] != oldColor || visited[i][j])
//            return;
//
//        visited[i][j] = true;
//        boolean border = i == 0 || j == 0 || j == m - 1 || i == n - 1 || grid[i + 1][j] != oldColor || grid[i - 1][j] != oldColor || grid[i][j - 1] != oldColor || grid[i][j + 1] != oldColor;
//
//        dfs(grid, i + 1, j, oldColor, visited, targetColor, n, m);
//        dfs(grid, i - 1, j, oldColor, visited, targetColor, n, m);
//        dfs(grid, i, j + 1, oldColor, visited, targetColor, n, m);
//        dfs(grid, i, j - 1, oldColor, visited, targetColor, n, m);
//
//        if (border)
//            grid[i][j] = targetColor;
//    }

//    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
//        helper(grid, row, col, grid[row][col], new int[][]{
//                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
//        });
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] < 0) {
//                    grid[i][j] = color;
//                }
//            }
//        }
//        return grid;
//    }
//
//    public static void helper(int[][] grid, int row, int column, int elementNeedToBeChange, final int[][] directions) {
//        grid[row][column] = -elementNeedToBeChange;
//        int count = 0;
//        for (int[] direction : directions) {
//            int nextRow = row + direction[0];
//            int nextColumn = column + direction[1];
//            if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid[0].length || Math.abs(grid[nextRow][nextColumn]) != elementNeedToBeChange) {
//                continue;
//            }
//            count++;
//            if (grid[nextRow][nextColumn] == elementNeedToBeChange) {
//                helper(grid, nextRow, nextColumn, elementNeedToBeChange, directions);
//            }
//        }
//        if (count == 4) {
//            grid[row][column] = elementNeedToBeChange;
//        }
//    }

    //
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        helper(grid, row, col, grid[row][col], color, new boolean[grid.length][grid[0].length]);
        return grid;
    }

    public static void helper(int[][] grid, int row, int column, int elementNeedToBeChange, int color, boolean[][] isVisited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] != elementNeedToBeChange || isVisited[row][column]) {
            return;
        }
        isVisited[row][column] = true;
        boolean isBoundaryOrColourable = row == 0 || column == 0 || row == grid.length - 1 || column == grid[0].length - 1 ||
                grid[row - 1][column] != elementNeedToBeChange || grid[row][column + 1] != elementNeedToBeChange ||
                grid[row + 1][column] != elementNeedToBeChange || grid[row][column - 1] != elementNeedToBeChange;
        helper(grid, row + 1, column, elementNeedToBeChange, color, isVisited);
        helper(grid, row - 1, column, elementNeedToBeChange, color, isVisited);
        helper(grid, row, column + 1, elementNeedToBeChange, color, isVisited);
        helper(grid, row, column - 1, elementNeedToBeChange, color, isVisited);
        if (isBoundaryOrColourable) {
            grid[row][column] = color;
        }
    }
}
