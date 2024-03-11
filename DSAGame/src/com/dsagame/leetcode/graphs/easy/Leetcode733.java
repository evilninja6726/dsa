package com.dsagame.leetcode.graphs.easy;

import java.util.Arrays;

public class Leetcode733 {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] res = floodFill(matrix, 1, 1, 7);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        helper(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public static void helper(int[][] image, int row, int column, int elementNeedsToBeChanged, int color) {
        if (row < 0 || column < 0 || row >= image.length || column >= image[0].length || image[row][column] != elementNeedsToBeChanged || image[row][column] == color) {
            return;
        }
        image[row][column] = color;
        for (int[] direction : new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) {
            helper(image, row + direction[0], column + direction[1], elementNeedsToBeChanged, color);
        }
    }
}
