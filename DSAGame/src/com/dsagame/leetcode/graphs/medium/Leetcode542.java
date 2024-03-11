package com.dsagame.leetcode.graphs.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Leetcode542 {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        int[][] res = updateMatrix(mat);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        Queue<Cell> queue = new ArrayDeque<>();
        int[][] directions = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Cell(i, j));
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            Cell front = queue.poll();
            for (int[] direction : directions) {
                int nextRow = front.row + direction[0];
                int nextColumn = front.column + direction[1];
                if (nextRow < 0 || nextColumn < 0 || nextRow >= mat.length || nextColumn >= mat[0].length || mat[nextRow][nextColumn] >= 0) {
                    continue;
                }
                queue.offer(new Cell(nextRow, nextColumn));
                mat[nextRow][nextColumn] = 1 + mat[front.row][front.column];
            }
        }
        return mat;
    }

    private static class Cell {
        int row, column;

        public Cell(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
