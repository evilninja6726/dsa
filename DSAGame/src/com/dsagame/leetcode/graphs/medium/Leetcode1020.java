package com.dsagame.leetcode.graphs.medium;

import java.util.Arrays;

public class Leetcode1020 {
    public static void main(String[] args) {

    }

    public static int numEnclaves(int[][] grid) {
        int countAllOnes = Arrays.stream(grid).flatMapToInt(Arrays::stream).sum();
        int countEnclaveOnes = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            countEnclaveOnes += helper(grid, 0, j, isVisited) + helper(grid, grid.length - 1, j, isVisited);
        }
        for (int i = 0; i < grid.length; i++) {
            countEnclaveOnes += helper(grid, i, 0, isVisited) + helper(grid, i, grid[0].length - 1, isVisited);
        }
        return countAllOnes - countEnclaveOnes;
    }

    public static int helper(int[][] grid, int row, int column, boolean[][] isVisited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == 0 || isVisited[row][column]) {
            return 0;
        }
        isVisited[row][column] = true;
        return 1 + helper(grid, row - 1, column, isVisited) +
                helper(grid, row, column + 1, isVisited) +
                helper(grid, row + 1, column, isVisited) +
                helper(grid, row, column - 1, isVisited);
    }
}
