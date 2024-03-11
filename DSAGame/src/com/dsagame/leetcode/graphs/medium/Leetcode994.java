package com.dsagame.leetcode.graphs.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode994 {
    public static void main(String[] args) {
        int[][] mat = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println(orangesRotting(mat));
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Triplet> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Triplet(i, j, 0));
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Triplet front = queue.poll();
            res = front.time;
            for (int[] direction : directions) {
                int nextRow = front.row + direction[0];
                int nextColumn = front.column + direction[1];
                if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid[0].length || grid[nextRow][nextColumn] != 1) {
                    continue;
                }
                if (grid[nextRow][nextColumn] == 1) {
                    queue.offer(new Triplet(nextRow, nextColumn, front.time + 1));
                    grid[nextRow][nextColumn] = 2;
                    fresh--;
                }
            }
        }
        return fresh > 0 ? -1 : res;
    }

    private static class Triplet {
        int row, column, time;

        public Triplet(int row, int column, int time) {
            this.row = row;
            this.column = column;
            this.time = time;
        }
    }
}
