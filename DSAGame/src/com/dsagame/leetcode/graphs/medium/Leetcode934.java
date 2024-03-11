package com.dsagame.leetcode.graphs.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode934 {
    public static void main(String[] args) {
        int[][] twoDArray = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 1}
        };
        System.out.println(shortestBridge(twoDArray));
    }

    public static int shortestBridge(int[][] grid) {
        Queue<Triplet> queue = new ArrayDeque<>();
        boolean foundIsland = false;
        for (int i = 0; i < grid.length && !foundIsland; i++) {
            for (int j = 0; j < grid[i].length && !foundIsland; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    foundIsland = true;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Triplet front = queue.poll();
            res = front.distance;
            for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nextRow = front.row + direction[0];
                int nextColumn = front.column + direction[1];
                if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid[0].length || grid[nextRow][nextColumn] == -1) {
                    continue;
                }
                if (grid[nextRow][nextColumn] == 1) {
                    return res;
                }
                grid[nextRow][nextColumn] = -1;
                queue.offer(new Triplet(nextRow, nextColumn, front.distance + 1));
            }
        }
        return -1;
    }

    public static void dfs(int[][] grid, int row, int column, Queue<Triplet> queue) {
        grid[row][column] = -1;
        queue.offer(new Triplet(row, column, 0));
        for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
            int nextRow = row + direction[0];
            int nextColumn = column + direction[1];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid[0].length || grid[nextRow][nextColumn] != 1) {
                continue;
            }
            dfs(grid, nextRow, nextColumn, queue);
        }
    }

    private static class Triplet {
        int row, column, distance;

        public Triplet(int row, int column, int distance) {
            this.row = row;
            this.column = column;
            this.distance = distance;
        }
    }
}

