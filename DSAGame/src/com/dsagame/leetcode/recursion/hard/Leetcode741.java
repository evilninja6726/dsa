package com.dsagame.leetcode.recursion.hard;

import java.util.concurrent.atomic.AtomicInteger;

public class Leetcode741 {


    public static void main(String[] args) {
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        System.out.println(cherryPickup(grid));
        System.out.println(cherryPickup(new int[][]{{1}}));

        int[][] matrix = {
                {1, 1, -1},
                {1, -1, 1},
                {-1, 1, 1}
        };
        System.out.println(cherryPickup(matrix));


        int[][] matrix2 = {
                {0, 0, 1, 0, 0, 1, 0, 1, 1, -1, 0, 0, -1, -1, 0, 1, 1, -1, 0, -1},
                {1, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, -1, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, -1, 1, 0, 0, 1, 0, 0, 1, 1},
                {-1, 0, -1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, -1, 1, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, -1, 1, 0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, -1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, -1, 0, -1, 0, 1, 0},
                {0, 1, -1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, -1, 1, 0, 0, -1, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, -1, 0, 1, 0, -1, 0, 0, 1, 0, 1, 1},
                {1, -1, -1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {-1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
                {0, 1, -1, 1, 1, 1, 0, 0, 1, -1, 1, 1, 0, 1, 0, 1, 0, -1, 1, 0},
                {1, -1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, -1, 0, 0, 1, 0, -1},
                {-1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, -1, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, -1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, -1, 0, -1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, -1, 0}
        };

        System.out.println(cherryPickup(matrix2));
    }

    public static int cherryPickup(int[][] grid) {
        //Backtracking
//        AtomicInteger res = new AtomicInteger();
//        topToBottomHelper(grid, 0, 0, 0, res);
//        return res.get();

        // Recursion
        //  return helper(grid, 0, 0, 0, 0);

        //Memo 4D DP
//        return Math.max(0, helper(grid, 0, 0, 0, 0, new int[grid.length][grid[0].length][grid.length][grid[0].length]));

        //Memo 3D DP
        return Math.max(0, helper(grid, 0, 0, 0, new int[grid.length][grid[0].length][grid.length]));
    }

    public static void topToBottomHelper(int[][] grid, int row, int column, int res, AtomicInteger max) {
        if (row == grid.length || column == grid[0].length || grid[row][column] == -1) {
            return;
        }
        if (row == grid.length - 1 && column == grid[0].length - 1) {
            bottomToTopHelper(grid, row, column, res, max);
            return;
        }
        int cherries = grid[row][column];
        grid[row][column] = 0;
        topToBottomHelper(grid, row + 1, column, res + cherries, max);
        topToBottomHelper(grid, row, column + 1, res + cherries, max);
        grid[row][column] = cherries;
    }

    public static void bottomToTopHelper(int[][] grid, int row, int column, int res, AtomicInteger max) {
        if (row < 0 || column < 0 || grid[row][column] == -1) {
            return;
        }
        if (row == 0 && column == 0) {
            max.set(Math.max(max.get(), res + grid[row][column]));
            return;
        }
        int cherries = grid[row][column];
        grid[row][column] = 0;
        bottomToTopHelper(grid, row - 1, column, res + cherries, max);
        bottomToTopHelper(grid, row, column - 1, res + cherries, max);
        grid[row][column] = cherries;
    }


    public static int helper(int[][] grid, int r1, int c1, int r2, int c2) {
        if (r1 == grid.length || c1 == grid[0].length || r2 == grid.length || c2 == grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }
        if (r2 == grid.length - 1 && c2 == grid[0].length - 1) {
            return grid[r2][c2];
        }
        int res = 0;
        if (r1 == r2 && c1 == c2) {
            res += grid[r1][c1];
        } else {
            res += (grid[r1][c1] + grid[r2][c2]);
        }
        int dd = helper(grid, r1 + 1, c1, r2 + 1, c2);
        int dl = helper(grid, r1 + 1, c1, r2, c2 + 1);
        int ld = helper(grid, r1, c1 + 1, r2 + 1, c2);
        int ll = helper(grid, r1, c1 + 1, r2, c2 + 1);
        res += Math.max(Math.max(dd, ll), Math.max(ld, dl));
        return res;
    }

    public static int helper(int[][] grid, int r1, int c1, int r2, int c2, int[][][][] dp) {
        if (r1 == grid.length || c1 == grid[0].length || r2 == grid.length || c2 == grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }
        if (r2 == grid.length - 1 && c2 == grid[0].length - 1) {
            return grid[r2][c2];
        }
        if (dp[r1][c2][r2][c2] != 0) {
            return dp[r1][c1][r2][c2];
        }
        int res = 0;
        if (r1 == r2 && c1 == c2) {
            res += grid[r1][c1];
        } else {
            res += (grid[r1][c1] + grid[r2][c2]);
        }
        int dd = helper(grid, r1 + 1, c1, r2 + 1, c2, dp);
        int dl = helper(grid, r1 + 1, c1, r2, c2 + 1, dp);
        int ld = helper(grid, r1, c1 + 1, r2 + 1, c2, dp);
        int ll = helper(grid, r1, c1 + 1, r2, c2 + 1, dp);
        res += Math.max(Math.max(dd, ll), Math.max(ld, dl));
        dp[r1][c1][r2][c2] = res;
        return res;
    }


    public static int helper(int[][] grid, int r1, int c1, int r2, int[][][] dp) {
        int c2 = r1 + c1 - r2;
        if (r1 == grid.length || c1 == grid[0].length || r2 == grid.length || c2 == grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c2][r2] != 0) {
            return dp[r1][c1][r2];
        }
        int res = 0;
        if (r1 == r2 && c1 == c2) {
            res += grid[r1][c1];
        } else {
            res += (grid[r1][c1] + grid[r2][c2]);
        }
        int dd = helper(grid, r1 + 1, c1, r2 + 1, dp);
        int dl = helper(grid, r1 + 1, c1, r2, dp);
        int ld = helper(grid, r1, c1 + 1, r2 + 1, dp);
        int ll = helper(grid, r1, c1 + 1, r2, dp);
        res += Math.max(Math.max(dd, ll), Math.max(ld, dl));
        dp[r1][c1][r2] = res;
        return res;
    }
}
