package com.dsagame.leetcode.graphs.medium;

import java.util.HashSet;

public class Leetcode694 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };
        System.out.println(numberOfDistinctIsland(grid));


        int[][] largeMatrix = {
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0}
        };


        int[][] largeMatrix1 = {
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}
        };


        System.out.println(numberOfDistinctIsland(largeMatrix));

        System.out.println(numberOfDistinctIsland(largeMatrix1));
    }

    public static int numberOfDistinctIsland(int[][] matrix) {
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        HashSet<String> uniquePaths = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !isVisited[i][j]) {
                    StringBuilder pathSoFar = new StringBuilder("C-");
                    helper(matrix, i, j, isVisited, pathSoFar);
                    uniquePaths.add(String.valueOf(pathSoFar));
                }
            }
        }
        System.out.println(uniquePaths);
        return uniquePaths.size();
    }

    public static void helper(int[][] matrix, int row, int column, boolean[][] isVisited, StringBuilder pathSoFar) {
        if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length || matrix[row][column] == 0 || isVisited[row][column]) {
            return;
        }
        isVisited[row][column] = true;
        helper(matrix, row - 1, column, isVisited, pathSoFar.append("U"));
        helper(matrix, row, column + 1, isVisited, pathSoFar.append("R"));
        helper(matrix, row + 1, column, isVisited, pathSoFar.append("D"));
        helper(matrix, row, column - 1, isVisited, pathSoFar.append("L"));
    }
}
