package com.dsagame.striver.atoz.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int right = matrix[0].length - 1;
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            bottom--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            if (top > bottom || left > right) {
                break;
            }
        }
        return res;
    }
}
