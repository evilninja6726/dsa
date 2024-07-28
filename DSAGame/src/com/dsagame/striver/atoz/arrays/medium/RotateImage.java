package com.dsagame.striver.atoz.arrays.medium;

public class RotateImage {
    public static void main(String[] args) {

    }

    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    public static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i++] ^= arr[j--];
        }
    }
}
