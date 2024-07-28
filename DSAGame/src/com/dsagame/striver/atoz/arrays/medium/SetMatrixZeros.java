package com.dsagame.striver.atoz.arrays.medium;

import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        int first = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        first = 0;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 && matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            Arrays.fill(matrix[0], 0);
        }

        if (first == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
