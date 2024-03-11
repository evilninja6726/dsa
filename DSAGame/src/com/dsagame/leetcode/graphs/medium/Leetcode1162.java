package com.dsagame.leetcode.graphs.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode1162 {
    public static void main(String[] args) {
        int[][] twoDArray = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        int[][] twoDArray1 = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        System.out.println(maxDistance(twoDArray1));
    }

    public static int maxDistance(int[][] grid) {
        Queue<Triplet> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = -1;
                } else {
                    queue.offer(new Triplet(i, j, 0));
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            Triplet front = queue.poll();
            res = Math.max(res, front.distance);
            for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
                int nextRow = front.row + direction[0];
                int nextColumn = front.column + direction[1];
                if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid.length || grid[nextRow][nextColumn] == 0) {
                    continue;
                }
                if (grid[nextRow][nextColumn] == -1) {
                    queue.offer(new Triplet(nextRow, nextColumn, front.distance + 1));
                    grid[nextRow][nextColumn] = 1;
                }
            }
        }
        return res == 0 ? -1 : res;
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
